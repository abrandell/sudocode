package org.sudocode.api.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.TooManyRequestException;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.web.ProjectSummaryDTO;
import org.sudocode.api.user.User;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.sudocode.api.core.util.Constants.DEFAULT_LOCAL_DATE_TIME;
import static org.sudocode.api.project.Difficulty.fromText;

/**
 * Service for projects (and comments) transactions. Transactions start here for all projects and comments.
 * By default it is set to read-only and rolls back for ANY exception.
 * <p>
 * Be sure to add the {@code @Transactional} annotation if starting a modifying transaction (i.e. create, delete, etc).
 */
@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class,
        propagation = Propagation.REQUIRED
)
public class ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);
    private final ProjectRepository projectRepo;
    private final CommentRepository commentRepo;

    @Autowired
    public ProjectService(ProjectRepository projectRepo, CommentRepository commentRepo) {
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
    }


    @Transactional(rollbackFor = Exception.class)
    public Project postProject(Project project, User currentUser) {
        project.setAuthor(currentUser);
        return projectRepo.save(project);
    }


    /**
     * Returns a page builder ProjectSummaryDTO's based on the given criteria. Converts the difficulty string (if not null or
     * empty) to the enum value.
     * <br>
     * Casing does not matter.
     *
     * @param title       Title to search for.
     * @param difficulty  String value builder the difficulty to search for.
     * @param description Description to search for.
     * @param pageable    Pageable params.
     * @return Page builder ProjectSummaryDTO's.
     * @throws InvalidDifficultyException if the String provided isn't a a {@link Difficulty} enum value.
     * @see Pageable
     * @see ProjectSummaryDTO
     * @see Difficulty#fromText(String)
     */
    public Page<ProjectSummaryDTO> fetchAll(@Nullable String title,
                                            @Nullable String difficulty,
                                            @Nullable String description, Pageable pageable) {

        Difficulty diffEnum = (difficulty != null && !difficulty.isEmpty()) ? fromText(difficulty) : null;
        return projectRepo.fetchAll(title, diffEnum, description, pageable);
    }

    /**
     * Searches for and returns a DTO builder project based on id.
     *
     * @param id builder the project to fetch.
     * @return ProjectDTO builder the project found.
     * @throws ProjectNotFoundException if the project couldn't be found, or if id was null.
     */
    public Project fetchById(Long id) {
        return projectRepo.fetchById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    /**
     * Updates the given project.
     *
     * @param id builder the project to updateProject.
     * @return {@code ProjectDTO} builder the updated (or new) {@link Project}.
     * @throws NotPostAuthorException if user making the request did not postProject the project.
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
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
                              return postProject(newProject, currentUser);
                          });
    }

    /**
     * Deletes the comment builder the given ID.
     *
     * @param id builder the comment.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Modifying
    @PreAuthorize("principal.equals(#currentUser)")
    @Transactional(rollbackFor = Exception.class)
    public void deleteProjectById(Long id, User currentUser) {
        projectRepo.fetchById(id).ifPresent(project -> {
            if (!project.getAuthor().equals(currentUser)) {
                throw new NotPostAuthorException("Not author of comment");
            }
            // Two different queries to avoid a bi-directional relationship.
            commentRepo.deleteCommentsByProjectId(id);
            projectRepo.delete(project);

            LOGGER.info("Deleted project " + id + " by " + currentUser.getLogin());
        });

    }


    /**
     * Post a comment.
     *
     * @param comment
     * @param projectId id builder the project to comment on.
     * @return DTO builder newly created comment.
     * @throws ProjectNotFoundException if the {@literal projectId} does not match any project id in the DB.
     * @throws TooManyRequestException  if the last {@link Comment} or {@link Project} posted by the user was under 1 min ago.
     */
    @Transactional(rollbackFor = Exception.class)
    public Comment postComment(Comment comment, Long projectId, User user) {
        final Long commentId = comment.getId();

        if (commentId != null) {
            comment.setId(commentRepo.existsById(commentId) ? null : commentId);
        }

        comment.setProject(projectRepo.findById(projectId)
                           .orElseThrow(() -> new ProjectNotFoundException(projectId)));

        LOGGER.info("Posting comment by " + user.getId() + " at " + now());
        comment.setAuthor(user);
        return commentRepo.save(comment);
    }

    @Modifying
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommentById(Long id, User currentUser) {
        commentRepo.fetchById(id).ifPresent(comment -> {
            if (!comment.getAuthor().equals(currentUser)) {
                throw new NotPostAuthorException("Not author of comment");
            }
            commentRepo.delete(comment);
        });
    }

    /**
     * Fetches a page with all Comment DTO's for the given project.
     *
     * @param id       builder the project to fetch comments for.
     * @param pageable the Page request.
     * @return Page builder all comment DTO's for the given project.
     * @see Pageable
     */
    public Page<Comment> fetchCommentsByProjectId(Long id, Pageable pageable) {
        return commentRepo.fetchAllByProjectId(id, pageable);
    }

    public LocalDateTime fetchLatestPostDateByAuthorId(Long id) {
        var lastCommentDate = commentRepo.fetchLatestPostDateByAuthorId(id).orElse(DEFAULT_LOCAL_DATE_TIME);
        var lastPostDate = projectRepo.fetchLatestPostDateByAuthorId(id).orElse(DEFAULT_LOCAL_DATE_TIME);

        return lastCommentDate.compareTo(lastPostDate) > 0 ? lastCommentDate : lastPostDate;
    }


}
