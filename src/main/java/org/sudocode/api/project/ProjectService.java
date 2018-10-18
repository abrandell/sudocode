package org.sudocode.api.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.core.TooManyRequestException;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.web.CommentForm;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;
import org.sudocode.api.project.web.ProjectPostForm;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.UserServiceImpl;
import org.sudocode.api.user.domain.User;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;

import static org.sudocode.api.project.domain.Difficulty.*;
import static org.sudocode.api.project.ProjectMapper.*;

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
public class ProjectServiceImpl implements ProjectService {

    private final UserService userService;
    private final ProjectRepository projectRepo;
    private final CommentRepository commentRepo;
    private final TimeOutService timeOutService;
    private final Log LOG = LogFactory.getLog(ProjectServiceImpl.class);

    @Autowired
    public ProjectServiceImpl(UserService userService, ProjectRepository projectRepo,
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
     * @return DTO of the newly posted project.
     * @see Project
     * @see ProjectPostForm
     */
    @Transactional(rollbackFor = Exception.class)
    public Project postProject(Project project, User currentUser) throws ExecutionException {
        timeOutService.handleIfTimedOut(currentUser.getId());

        timeOutService.ensureNotSpamming(
                currentUser.getId(),
                projectRepo.fetchLatestPostDateByAuthorId(currentUser.getId())
        );

        project.setAuthor(currentUser);
        return projectRepo.save(project);
    }

    public ProjectDTO postProjectDTO(Project project, User currentUser) throws ExecutionException {
        return projectToDTO(postProject(project, currentUser));
    }

    /**
     * Returns a page of ProjectSummaryDTO's based on the given criteria. Converts the difficulty string (if not null or
     * empty) to the enum value.
     * <br>
     * Casing does not matter.
     *
     * @param title       Title to search for.
     * @param difficulty  String value of the difficulty to search for.
     * @param description Description to search for.
     * @param pageable    Pageable params.
     * @return Page of ProjectSummaryDTO's.
     * @see Pageable
     * @see ProjectSummaryDTO
     * @see Difficulty#fromText(String)
     * @throws InvalidDifficultyException if the String provided isn't a a {@link Difficulty} enum value.
     *
     */
    public Page<ProjectSummaryDTO> fetchAll(@Nullable String title,
                                            @Nullable String difficulty,
                                            @Nullable String description,
                                            Pageable pageable) {

        Difficulty difficultyEnum = (difficulty != null && !difficulty.isEmpty()) ? fromText(difficulty) : null;

        return projectRepo.fetchAll(title, difficultyEnum, description, pageable);
    }

    /**
     * Searches for and returns a DTO of project based on id.
     *
     * @param id of the project to fetch.
     * @return ProjectDTO of the project found.
     * @throws ProjectNotFoundException if the project couldn't be found, or if id was null.
     */
    public ProjectDTO fetchDTOById(Long id) {
        return projectRepo.fetchDTOById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    /**
     * Updates the given project.
     *
     * @param id              of the project to update.
     * @return {@code ProjectDTO} of the updated project.
     * @throws NotPostAuthorException if user making the request did not postProject the project.
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectDTO update(Long id, Project project) throws ExecutionException {
        if (projectRepo.existsById(id)) {
            Project updated = projectRepo.getOne(id);

            if (updated.getAuthor() != userService.currentUser()) {
                throw new NotPostAuthorException("Not owner of project.");
            }

            updated.setTitle(project.getTitle());
            updated.setDifficulty(project.getDifficulty());
            updated.setDescription(project.getDescription());
            return projectToDTO(updated);
        }

        // TODO this is unneeded.
        return postProjectDTO(project, userService.fetchById(id));
    }

    /**
     * Deletes the comment of the given ID.
     *
     * @param id of the comment.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Project found = projectRepo.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));

        if (found.getAuthor() != userService.currentUser()) {
            throw new NotPostAuthorException("Not author of project.");
        }

        projectRepo.delete(found);
    }


    /**
     * Post a comment.
     *
     * @param commentForm CommentForm DTO for comment-creation.
     * @param projectId   id of the project to comment on.
     * @return DTO of newly created comment.
     * @throws ProjectNotFoundException if the {@literal projectId} does not match any project id in the DB.
     * @throws TooManyRequestException  if the last {@link Comment} or {@link Project} posted by the user was under 1 min ago.
     */
    @Transactional(rollbackFor = Exception.class)
    public CommentDTO postComment(Comment comment, Long projectId,
                                  User currentUser) throws ExecutionException {

        timeOutService.handleIfTimedOut(currentUser.getId());

        timeOutService.ensureNotSpamming(
                currentUser.getId(),
                commentRepo.fetchLatestPostDateByAuthorId(currentUser.getId())
        );

        LOG.info("Posting comment by " + currentUser.getId() + " at" + LocalTime.now());

        comment.setProject(projectRepo.findById(projectId)
                                      .orElseThrow(() -> new ProjectNotFoundException(projectId)));

        comment.setAuthor(currentUser);

        return new CommentDTO(commentRepo.save(comment));
    }

/*    @Transactional(rollbackFor = Exception.class)
    public CommentDTO updateComment(CommentForm commentForm, Long projectId, User currentUser) throws ExecutionException {
        final Long userId = currentUser.getId();

        timeOutService.handleIfTimedOut(userId);

        timeOutService.ensureNotSpamming(userId, commentRepo.fetchLatestPostDateByAuthorId(userId));


    }*/

    /**
     * Delete a comment.
     *
     * @param id of the comment to be deleted.
     * @throws NotPostAuthorException if the user making the request did not postProject the comment.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommentById(Long id) {
        Comment comment = commentRepo.fetchById(id).orElseThrow(() -> new CommentNotFoundException(id));

        if (!comment.getAuthor().equals(userService.currentUser())) {
            throw new NotPostAuthorException("Not author of comment.");
        }

        this.commentRepo.deleteById(id);
    }

    /**
     * Fetches a page with all Comment DTO's for the given project.
     *
     * @param id       of the project to fetch comments for.
     * @param pageable the Page request.
     * @return Page of all comment DTO's for the given project.
     * @see Pageable
     */
    public Page<CommentDTO> fetchCommentsByProjectId(Long id, Pageable pageable) {
        return commentRepo.fetchDTOPageByProjectId(id, pageable);
    }


}
