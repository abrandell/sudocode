package org.sudocode.api.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.SecurityUtils;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.core.TooManyRequestException;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentForm;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;
import org.sudocode.api.project.dto.ProjectDTO;
import org.sudocode.api.project.dto.ProjectSummary;
import org.sudocode.api.project.web.ProjectPost;
import org.sudocode.api.user.UserNotLoggedInException;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.sudocode.api.project.domain.Difficulty.*;
import static org.sudocode.api.project.dto.ProjectMapper.*;

/**
 * Service for projects (and comments) transactions. Transactions start here for all projects and comments.
 * By default it is set to read-only and rolls back for ANY exception.
 * <p>
 * Be sure to add the {@code @Transactional} annotation if starting a modifying transaction.
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

    @Autowired
    public ProjectService(UserService userService, ProjectRepository projectRepo, CommentRepository commentRepo, TimeOutService timeOutService) {
        this.userService = userService;
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
        this.timeOutService = timeOutService;
    }

    /**
     * Post a new project.
     *
     * @param postForm The ProjectPost form. A DTO for project-creation.
     * @return DTO of the newly posted project.
     * @see Project
     * @see ProjectPost
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectDTO post(ProjectPost postForm) {
        Project project = new Project();

        project.setTitle(postForm.getTitle());
        project.setDescription(postForm.getDescription());
        project.setDifficulty(postForm.getDifficulty());
        project.setAuthor(userService.currentUser());

        return projectToDTO(projectRepo.save(project));
    }

    /**
     * Returns a page of ProjectSummary's based on the given criteria. Converts the difficulty string (if not null or
     * empty) to the enum value.
     * <br>
     * Casing does not matter.
     *
     * @param title       Title to search for.
     * @param difficulty  String value of the difficulty to search for.
     * @param description Description to search for.
     * @param pageable    Pageable params.
     * @return Page of ProjectSummary's.
     * @see Pageable
     * @see ProjectSummary
     */
    public Page<ProjectSummary> fetchAll(@Nullable String title, @Nullable String difficulty,
                                         @Nullable String description, Pageable pageable) {

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
    public ProjectDTO fetchById(Long id) {
        return projectToDTO(projectRepo.findById(id).orElseThrow(() -> new ProjectNotFoundException(id)));
    }

    /**
     * Deletes the comment of the given ID.
     *
     * @param id of the comment.
     * @throws NotPostAuthorException if the user making the request did not post the comment.
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
     * Updates the given project.
     *
     * @param id              of the project to update.
     * @param projectPostForm values to update for said project.
     * @return {@code ProjectDTO} of the updated project.
     * @throws NotPostAuthorException if user making the request did not post the project.
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectDTO update(Long id, ProjectPost projectPostForm) {
        if (projectRepo.existsById(id)) {
            Project updated = projectRepo.getOne(id);

            if (updated.getAuthor() != userService.currentUser()) {
                throw new NotPostAuthorException("Not owner of project.");
            }

            updated.setTitle(projectPostForm.getTitle());
            updated.setDifficulty(projectPostForm.getDifficulty());
            updated.setDescription(projectPostForm.getDescription());
            return projectToDTO(updated);
        }

        return post(projectPostForm);
    }

    /**
     * Post a comment.
     *
     * @param commentForm CommentForm DTO for comment-creation.
     * @param projectId   id of the project to comment on.
     * @return DTO of newly created comment.
     * @throws ProjectNotFoundException if the {@literal projectId} does not match any project id in the DB.
     * @throws TooManyRequestException if the last comment made by the user was under 1 min ago.
     */
    @Transactional(rollbackFor = Exception.class)
    public CommentDTO postComment(CommentForm commentForm, Long projectId) {
        User currentUser = SecurityUtils.getCurrentUser().orElseThrow(UserNotLoggedInException::new);

        if (timeOutService.isTimedOut(currentUser.getId())) {
            throw new TooManyRequestException();
        }

        ensureNotSpamming(currentUser.getId());

        Comment comment = new Comment();
        comment.setBody(commentForm.getBody());
        comment.setProject(
                projectRepo.findById(projectId)
                           .orElseThrow(() -> new ProjectNotFoundException(projectId))
        );

        comment.setAuthor(userService.currentUser());

        return new CommentDTO(commentRepo.save(comment));
    }

    /**
     * Delete a comment.
     *
     * @param id of the comment to be deleted.
     * @throws NotPostAuthorException if the user making the request did not post the comment.
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
        return commentRepo.fetchAllByProjectId(id, pageable).map(CommentDTO::new);
    }

    // TODO rename me. Checks last time posted and times out the user for 5 mins if it was under 1 min ago.
    private void ensureNotSpamming(Long userId) {
        LocalDateTime latestPostDate = commentRepo.fetchLatestByAuthorId(userId);

        if (latestPostDate != null) {
            var now = LocalDateTime.now();
            assert now.isAfter(latestPostDate);

            long secPassed = Duration.between(latestPostDate, now).toSeconds();

            if (secPassed < 30) {
                timeOutService.timeOutUser(userId);
                throw new TooManyRequestException();
            }

        }
    }
}
