package org.sudocode.api.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.sudocode.api.core.annotation.ReadOnlyTX;
import org.sudocode.api.core.annotation.TransactionalService;
import org.sudocode.api.core.exception.InvalidDifficultyException;
import org.sudocode.api.core.exception.NotPostAuthorException;
import org.sudocode.api.core.exception.ProjectNotFoundException;
import org.sudocode.api.core.security.AuthFacade;
import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.comment.CommentRepository;
import org.sudocode.api.post.comment.CommentView;
import org.sudocode.api.post.project.Difficulty;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.post.project.ProjectRepository;
import org.sudocode.api.post.project.ProjectView;
import org.sudocode.api.user.User;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.sudocode.api.core.Constants.LOCAL_DATE_TIME_MIN;
import static org.sudocode.api.post.project.Difficulty.difficultyEnumFromValue;

/**
 * Service for project and comment transactions.
 * @see TransactionalService
 */
@TransactionalService
public class PostingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostingService.class);
    private final ProjectRepository projectRepo;
    private final CommentRepository commentRepo;
    private final VoteRepository voteRepo;
    private final AuthFacade auth;

    @Autowired
    public PostingService(ProjectRepository projectRepo, CommentRepository commentRepo, VoteRepository voteRepo, AuthFacade auth) {
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
        this.voteRepo = voteRepo;
        this.auth = auth;
    }

    /**
     * Post a project.
     * @return the saved project.
     */
    public Project postProject(Project project) {
        return projectRepo.save(project);
    }

    /**
     * Returns a page of {@link ProjectView} projections based on the given params.
     * <p>Converts the difficulty string (if not null or empty) to the {@link Difficulty}
     * enum. Casing does not matter.
     * @return Page of {@link ProjectView}'s.
     * @throws InvalidDifficultyException if the difficulty param string isn't {@link Difficulty} enum value.
     * @see Pageable
     * @see ProjectView
     * @see Difficulty#difficultyEnumFromValue(String)
     */
    @ReadOnlyTX
    public Page<ProjectView> fetchAllProjectViews(String title, String difficultyStr,
                                                  String description, Pageable pageable) {

        var diffEnum = isNotBlank(difficultyStr) ? difficultyEnumFromValue(difficultyStr)
                                                 : null;

        return projectRepo.filterAll(title, diffEnum, description, pageable);
    }

    /**
     * Searches for and returns a {@link ProjectView} projection of the project with the
     * given id.
     * @param id of the project to fetch.
     * @return The {@link ProjectView} projection of the {@link Project} if found.
     */
    @ReadOnlyTX
    public ProjectView fetchProjectViewById(Long id) {
        return projectRepo.fetchViewById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    /**
     * Updates the given project.
     * @param id of the project to update. Must not be null.
     * @param newProject The project with the fields/properties to update to the existing
     * or new entity.
     * @return The updated (or new) {@link Project}.
     */
    public Project updateProject(Long id, Project newProject) {
        return projectRepo.fetchById(id)
                          .filter(project -> project.isPostedBy(auth.currentUser()))
                          .map(project -> {
                              project.setTitle(newProject.getTitle());
                              project.setDescription(newProject.getDescription());
                              project.setDifficulty(newProject.getDifficulty());
                              return project;
                          })
                          .orElseGet(() -> {
                              /* Make sure not to replace an already existing project */
                              newProject.setId(projectRepo.existsById(id) ? null : id);
                              return postProject(newProject);
                          });
    }

    /**
     * Delete the comment with the given ID.
     * @param id of the comment.
     * @throws NotPostAuthorException if the user making the request did not post the project.
     */
    public void deleteProjectById(Long id) {
        projectRepo.fetchById(id).ifPresent(project -> {
            if (!project.isPostedBy(auth.currentUser())) {
                throw new NotPostAuthorException("Not author of comment");
            }
            // Two different queries to avoid a bi-directional relationship.
            commentRepo.deleteCommentsByProjectId(id);
            projectRepo.delete(project);

            LOGGER.debug("Deleted project ID: {} by {}", id, auth.currentUser());
        });

    }

    /**
     * Post a comment.
     * @param projectId id of the project to comment on.
     * @return The newly created comment.
     * @throws ProjectNotFoundException if the projectId does not match any project id in
     * the DB.
     */
    public Comment postComment(Comment comment, Long projectId) {
        comment.setProject(
                projectRepo.findById(projectId)
                           .orElseThrow(() -> new ProjectNotFoundException(projectId))
        );
        LOGGER.debug("Posting comment by user ID: {} at {}", auth.currentUser().getId(), now());
        return commentRepo.save(comment);
    }

    /**
     * Update a comment if it exists, else posts a new.
     * @param updated The new or existing comment to make changes to.
     * @param commentId The ID of the comment to update.
     * @param projectId ID of the project the comment was posted on.
     * @return The updated or newly created comment.
     */
    public Comment updateComment(Comment updated, Long commentId, Long projectId) {
        return commentRepo.fetchById(commentId)
                          .filter(comment -> comment.isPostedBy(auth.currentUser()))
                          .map(comment -> {
                              comment.setBody(updated.getBody());
                              return comment;
                          })
                          .orElseGet(() -> {
                              // Make sure not to replace an already existing comment
                              updated.setId(commentRepo.existsById(commentId) ? null : commentId);
                              return postComment(updated, projectId);
                          });
    }

    /**
     * Delete a comment.
     * @param id of the comment to be deleted.
     * @throws NotPostAuthorException if the user making the request did not post the comment.
     */
    public void deleteCommentById(Long id) {
        commentRepo.fetchById(id).ifPresent(comment -> {
            if (!comment.isPostedBy(auth.currentUser())) {
                throw new NotPostAuthorException("Not author of comment");
            }
            commentRepo.delete(comment);
        });
    }

    /* Works, but too expensive and difficult to test. TODO: refactor */
    public void voteOnProject(VoteEnum voteEnum, Long projectId) {
        Project project = projectRepo.findById(projectId)
                                     .orElseThrow(() -> new ProjectNotFoundException(projectId));

        voteRepo.fetchByUserAndProjectId(projectId, auth.currentUser().getId())
                .map(vote -> {
                    vote.setDir(voteEnum);
                    return vote;
                }).orElseGet(() -> voteRepo.save(new Vote(voteEnum, auth.currentUser(), project))
        );

        int totalRating = voteRepo.fetchAllByProjectId(projectId)
                                  .mapToInt(v -> v.getDir().primitiveValue())
                                  .sum();

        projectRepo.setRating(projectId, totalRating);
    }

    /**
     * Fetches a page with all comments projections for the given project.
     * @param id id of the project to fetch comments for.
     * @param pageable the Page request.
     * @return Page of {@link CommentView} projections for the given project.
     * @see Pageable
     * @see CommentView
     */
    @ReadOnlyTX
    public Page<CommentView> fetchCommentViewsByProjectId(Long id, Pageable pageable) {
        return commentRepo.fetchCommentViewsByProjectId(id, pageable);
    }

    /**
     * Returns the latest {@link LocalDateTime} of a post made by a {@link User} with the
     * given id.
     * <p>This method exists for {@link org.sudocode.api.core.security.timeout.TimeOutService}.
     * <p>If no results are found, it returns {@link LocalDateTime#MIN}
     * @param id The ID of the User.
     * @return The {@link LocalDateTime} of the latest post made from the {@link User} if
     * exists, else {@link LocalDateTime#MIN}.
     */
    @ReadOnlyTX
    public LocalDateTime fetchLatestPostDateByAuthorId(Long id) {
        var lastCommentDate = commentRepo.lastPostDateByUserId(id).orElse(LOCAL_DATE_TIME_MIN);
        var lastPostDate = projectRepo.lastPostDateByUserId(id).orElse(LOCAL_DATE_TIME_MIN);

        return lastCommentDate.compareTo(lastPostDate) > 0 ? lastCommentDate
                                                           : lastPostDate;
    }
}
