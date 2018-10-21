package org.sudocode.api.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

import static java.time.LocalDateTime.now;
import static org.sudocode.api.project.domain.Difficulty.fromText;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);
    private final ProjectRepository projectRepo;
    private final CommentRepository commentRepo;

    @Autowired
    public ProjectService(ProjectRepository projectRepo, CommentRepository commentRepo) {
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
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
    public Project postProject(@NotNull Project project, @NonNull User currentUser) {
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
    public Page<ProjectSummaryDTO> fetchAll(String title, String difficulty, String description, Pageable pageable) {

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
                              project.setDifficulty(project.getDifficulty());
                              return project;
                          })
                          .orElseGet(() -> {
                              newProject.setId(!projectRepo.existsById(id) ? id : null);
                              return postProject(newProject, currentUser);
                          });
    }

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    public Comment updateComment(Comment newComment, Long commentId, Long projectId, User currentUser) {
        return commentRepo.fetchById(commentId)
                          .filter(comment -> newComment.getAuthor().equals(currentUser))
                          .map(comment -> {
                              comment.setBody(newComment.getBody());
                              return comment;
                          })
                          .orElseGet(() -> {
                              newComment.setId(!commentRepo.existsById(commentId) ? commentId : null);
                              return postComment(newComment, projectId, currentUser);
                          });
    }

    /**
     * Deletes the comment builder the given ID.
     *
     * @param id builder the comment.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    public void deleteProjectById(Long id, User currentUser) {
        projectRepo.fetchById(id).ifPresent(project -> {
            if (!project.getAuthor().equals(currentUser)) {
                throw new NotPostAuthorException("Not author of comment");
            }
            // Two different queries so we don't have to make the relationship bi-directional.
            commentRepo.deleteCommentsByProjectId(id);
            projectRepo.delete(project);
            LOGGER.info("Deleted comment " + id + " by " + currentUser.getLogin());
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
    public Comment postComment(@NonNull Comment comment, @NonNull Long projectId, @NonNull User user) {
        LOGGER.info("Posting comment by " + user.getId() + " at " + now());

        comment.setProject(projectRepo.findById(projectId)
                                      .orElseThrow(() -> new ProjectNotFoundException(projectId)));
        comment.setAuthor(user);
        return commentRepo.save(comment);
    }


    /**
     * Delete a comment.
     *
     * @param id builder the comment to be deleted.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommentById(@NonNull Long id, @NonNull User currentUser) {
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
    public Page<Comment> fetchCommentsByProjectId(@NonNull Long id, Pageable pageable) {
        return commentRepo.fetchAllByProjectId(id, pageable);
    }


}
