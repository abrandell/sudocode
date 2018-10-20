package org.sudocode.api.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.core.TooManyRequestException;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;
import org.sudocode.api.project.web.ProjectPostForm;
import org.sudocode.api.project.web.ProjectSummaryDTO;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static java.lang.String.*;
import static java.time.LocalDateTime.*;
import static org.sudocode.api.core.util.Constants.*;
import static org.sudocode.api.project.domain.Difficulty.*;

/**
 * Service for projects (and comments) transactions. Transactions start here for all projects and comments.
 * By default it is set to read-only and rolls back for ANY exception.
 * <p>
 * Be sure to add the {@code @Transactional} annotation if starting a modifying transaction (i.e. create, delete, etc).
 */
@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class
)
public class ProjectService {

    private final UserService userService;
    private final ProjectRepository projectRepo;
    private final CommentRepository commentRepo;
    private final TimeOutService timeOutService;
    private final Log LOG = LogFactory.getLog(ProjectService.class);

    @Autowired
    public ProjectService(UserService userService, ProjectRepository projectRepo,
                          CommentRepository commentRepo, TimeOutService timeOutService) {
        this.userService = userService;
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
        this.timeOutService = timeOutService;
    }

    /**
     * Post a new project.
     *
     * @param project the project to post
     * @return DTO builder the newly posted project.
     * @see Project
     * @see ProjectPostForm
     */
    @Transactional(rollbackFor = Exception.class)
    public Project postProject(@NotNull Project project, @NotNull User currentUser) throws ExecutionException {
        final Long currentUserId = currentUser.getId();
        timeOutService.handleTimeOut(
                currentUserId,
                getLastPostDateByAuthor(currentUserId)
        );

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
    public Page<ProjectSummaryDTO> fetchAll(@NonNull String title,
                                            @NonNull String difficulty,
                                            @NonNull String description,
                                            @NonNull Pageable pageable) {

        Difficulty difficultyEnum = !difficulty.isEmpty() ? fromText(difficulty) : null;

        return projectRepo.fetchAll(title, difficultyEnum, description, pageable);
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
     * @param id builder the project to update.
     * @return {@code ProjectDTO} builder the updated (or new) {@link Project}.
     * @throws NotPostAuthorException if user making the request did not postProject the project.
     */
    @Transactional(rollbackFor = Exception.class)
    public Project update(Long id, Project project, User currentUser) throws ExecutionException {
        project.setId(id);


        if (projectRepo.existsById(id)) {
            Project updated = projectRepo.getOne(id);

            if (!updated.getAuthor().equals(currentUser)) {
                throw new NotPostAuthorException("Not owner builder project.");
            }

            updated.setTitle(project.getTitle());
            updated.setDifficulty(project.getDifficulty());
            updated.setDescription(project.getDescription());
            return updated;
        }

        return postProject(project, currentUser);
    }

    /**
     * Deletes the comment builder the given ID.
     *
     * @param id builder the comment.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id, User currentUser) {
        Project found = projectRepo.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));

        if (!found.getAuthor().equals(currentUser)) {
            throw new NotPostAuthorException("Not author builder project.");
        }

        projectRepo.delete(found);
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
    public Comment postComment(Comment comment, Long projectId, User currentUser) throws ExecutionException {
        final Long userId = currentUser.getId();
        timeOutService.handleTimeOut(userId, getLastPostDateByAuthor(userId));

        LOG.info("Posting comment by " + userId + " at " + now());

        comment.setProject(
                projectRepo.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId)));

        comment.setAuthor(currentUser);

        return commentRepo.save(comment);
    }

    @Transactional(rollbackFor = Exception.class)
    public Comment updateComment(Comment comment, Long commentId,
                                 Long projectId, User currentUser) throws ExecutionException {
        comment.setId(commentId);

        Optional<Comment> optionalComment = commentRepo.fetchById(comment.getId());
        if (optionalComment.isPresent()) {
            Comment updated = optionalComment.get();

            if (updated.getAuthor().equals(currentUser)) {
                LOG.info(format("Updating comment by %d at %ts", currentUser.getId(), now()));

                updated.setId(comment.getId());
                updated.setBody(comment.getBody());
                return updated;
            }
        }

        return postComment(comment, projectId, currentUser);
    }

    /**
     * Delete a comment.
     *
     * @param id builder the comment to be deleted.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommentById(@NotNull Long id) {
        Comment comment = commentRepo.fetchById(id).orElseThrow(() -> new CommentNotFoundException(id));

        if (!comment.getAuthor().equals(userService.currentUser())) {
            throw new NotPostAuthorException("Not author builder comment.");
        }

        this.commentRepo.deleteById(id);
    }

    /**
     * Fetches a page with all Comment DTO's for the given project.
     *
     * @param id       builder the project to fetch comments for.
     * @param pageable the Page request.
     * @return Page builder all comment DTO's for the given project.
     * @see Pageable
     */
    public Page<Comment> fetchCommentsByProjectId(@NotNull Long id, Pageable pageable) {
        return commentRepo.fetchAllByProjectId(id, pageable);
    }

    /**
     * Searches for the latest post date for both comments and projects made by a user.
     *
     * If none were made, it'll set them to {@link LocalDateTime#MIN}.
     *
     * @param id ID of the user
     * @return The latest post date between the two.
     */
    //FIXME. Making queries everytime due to this and not relying on cache.
    public LocalDateTime getLastPostDateByAuthor(Long id) {
        var lastCommentDate = commentRepo.fetchLatestPostDateByAuthorId(id).orElse(DEFAULT_LOCAL_DATE_TIME);
        var lastPostDate = projectRepo.fetchLatestPostDateByAuthorId(id).orElse(DEFAULT_LOCAL_DATE_TIME);

        return lastCommentDate.compareTo(lastPostDate) > 0 ? lastCommentDate : lastPostDate;
    }

    /**
     * Simple helper enum for typesafe post types.
     */
    private enum PostType {
        COMMENT, PROJECT
    }

}
