package org.sudocode.api.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.annotation.ModifyingTX;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;
import org.sudocode.api.core.exceptions.NotPostAuthorException;
import org.sudocode.api.core.exceptions.ProjectNotFoundException;
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
import static org.apache.commons.lang3.StringUtils.*;
import static org.sudocode.api.core.util.Constants.DEFAULT_LOCAL_DATE_TIME;
import static org.sudocode.api.post.project.Difficulty.*;

/**
 * Service for projects and comments transactions. Transactions start here for all projects and comments.
 * By default it is set to read-only and rolls back for ANY exception.
 * <p>
 */
@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class,
        propagation = Propagation.REQUIRES_NEW
)
public class PostingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostingService.class);
    private final ProjectRepository projectRepo;
    private final CommentRepository commentRepo;

    @Autowired
    public PostingService(ProjectRepository projectRepo, CommentRepository commentRepo) {
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
    }

    @ModifyingTX
    public Project postProject(Project project) {
        return projectRepo.save(project);
    }


    /**
     * Returns a page of {@link ProjectView} projections based on the given criteria.
     * Converts the difficulty string (if not null or empty) to the {@link Difficulty} enum.
     * <br>
     * Casing does not matter.
     *
     * @param title       Title to search for.
     * @param difficultyStr  String value of the difficulty to search for.
     * @param description Description to search for.
     * @param pageable    Pageable params.
     * @return Page of {@link ProjectView}s.
     * @throws InvalidDifficultyException if the difficulty param string isn't a {@link Difficulty} enum value.
     * @see Pageable
     * @see ProjectView
     * @see Difficulty#difficultyEnumFromValue(String)
     */
    public Page<ProjectView> fetchAllProjectViews(@Nullable String title,
                                                  @Nullable String difficultyStr,
                                                  @Nullable String description, Pageable pageable) {

        var difficultyEnum = isNotBlank(difficultyStr) ? difficultyEnumFromValue(difficultyStr) : null;

        return projectRepo.filterAll(title, difficultyEnum, description, pageable);
    }

    /**
     * Searches for and returns a {@link ProjectView} projection of the project with the given id.
     *
     * @param id of the project to fetch.
     * @return The {@link ProjectView} projection of the {@link Project} if found.
     */
    public ProjectView fetchProjectViewById(Long id) {
        return projectRepo.findViewById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    /**
     * Updates the given project.
     *
     * @param id of the project to update..
     * @return The updated (or new) {@link Project}.
     */
    @ModifyingTX
    public Project updateProject(Long id, Project newProject, User currentUser) {
        return projectRepo.fetchById(id)
                          .filter(project -> project.getAuthor().equals(currentUser))
                          .map(project -> {
                              project.setTitle(newProject.getTitle());
                              project.setDescription(newProject.getDescription());
                              project.setDifficulty(newProject.getDifficulty());
                              return project;
                          })
                          .orElseGet(() -> {
                              // Make sure not to replace an already existing project
                              newProject.setId(projectRepo.existsById(id) ? null : id);
                              return projectRepo.save(newProject);
                          });
    }

    /**
     * Deletes the comment builder the given ID.
     *
     * @param id of the comment.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @ModifyingTX
    public void deleteProjectById(Long id, User currentUser) {
        projectRepo.fetchById(id).ifPresent(project -> {
            if (!project.getAuthor().equals(currentUser)) {
                throw new NotPostAuthorException("Not author of comment");
            }
            // Two different queries to avoid a bi-directional relationship.
            commentRepo.deleteCommentsByProjectId(id);
            projectRepo.delete(project);

            LOGGER.info("Deleted project ID: {} by {}", id, currentUser.getLogin());
        });

    }


    /**
     * Post a comment.
     *
     * @param comment   Comment to post..
     * @param projectId id of the project to comment on.
     * @return The newly created comment.
     * @throws ProjectNotFoundException if the projectId does not match any project id in the DB.
     */
    @ModifyingTX
    public Comment postComment(Comment comment, Long projectId, User user) {
        comment.setProject(
                projectRepo.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId))
        );

        LOGGER.info("Posting comment by user ID: {} at {}", user.getId(), now());
        return commentRepo.save(comment);
    }

    @ModifyingTX
    public Comment updateComment(Comment newComment, Long commentId, Long projectId, User currentUser) {
        return commentRepo.fetchById(commentId)
                          .filter(comment -> comment.getAuthor().equals(currentUser))
                          .map(comment -> {
                              comment.setBody(newComment.getBody());
                              return comment;
                          })
                          .orElseGet(() -> {
                              // Make sure not to replace an already existing comment
                              newComment.setId(commentRepo.existsById(commentId) ? null : commentId);
                              return postComment(newComment, projectId, currentUser);
                          });
    }


    /**
     * Delete a comment.
     *
     * @param id builder the comment to be deleted.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @ModifyingTX
    public void deleteCommentById(Long id, User currentUser) {
        commentRepo.fetchById(id).ifPresent(comment -> {
            if (!comment.getAuthor().equals(currentUser)) {
                throw new NotPostAuthorException("Not author of comment");
            }
            commentRepo.delete(comment);
        });
    }

    /**
     * Fetches a page with all comments for the given project.
     *
     * @param id       id of the project to fetch comments for.
     * @param pageable the Page request.
     * @return Page of all comments for the given project.
     * @see Pageable
     */
    public Page<CommentView> fetchCommentViewsByProjectId(Long id, Pageable pageable) {
        return commentRepo.fetchCommentViewsByProjectId(id, pageable);
    }

    /**
     * Returns the latest {@link LocalDateTime} of a post made by a {@link User} with the given id.
     * <br>
     *
     * This method exists for {@link org.sudocode.api.core.security.timeout.TimeOutService}.
     * <br>
     *
     * If no results are found, it returns {@link LocalDateTime#MIN}
     *
     * @param id The ID of the User.
     * @return The {@link LocalDateTime} of the latest post made from the {@link User} if exists, else {@link LocalDateTime#MIN}.
     */
    public LocalDateTime fetchLatestPostDateByAuthorId(Long id) {
        var lastCommentDate = commentRepo.fetchLatestPostDateByAuthorId(id).orElse(DEFAULT_LOCAL_DATE_TIME);
        var lastPostDate = projectRepo.fetchLatestPostDateByAuthorId(id).orElse(DEFAULT_LOCAL_DATE_TIME);

        return lastCommentDate.compareTo(lastPostDate) > 0 ? lastCommentDate : lastPostDate;
    }


}
