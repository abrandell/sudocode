package org.sudocode.api.project.web.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.project.ProjectNotFoundException;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.web.ProjectDTO;
import org.sudocode.api.project.web.ProjectMapper;
import org.sudocode.api.project.web.ProjectSummaryDTO;
import org.sudocode.api.user.domain.User;

import java.util.concurrent.ExecutionException;

import static org.sudocode.api.core.util.Constants.JSON;


/**
 * RestController for {@link org.sudocode.api.project.domain.Project}.
 */
@RestController
@RequestMapping("api/projects")
public final class ProjectRestController {

    private final ProjectService projectService;
    private final TimeOutService timeOutService;
    private final ProjectMapper projectMapper;
    private final CommentMapper commentMapper;
    private final Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    public ProjectRestController(ProjectService projectService, TimeOutService timeOutService,
                                 ProjectMapper projectMapper, CommentMapper commentMapper) {
        this.projectService = projectService;
        this.timeOutService = timeOutService;
        this.projectMapper = projectMapper;
        this.commentMapper = commentMapper;
    }

    /**
     * POST /api/projects
     *
     * @see ProjectService#postProject(Project, User)
     */
    @PostMapping(consumes = JSON, produces = JSON)
    public ProjectDTO post(@RequestBody Project project, @AuthenticationPrincipal User currentUser)
            throws ExecutionException {
        project.setId(null);

        timeOutService.handleTimeOut(currentUser.getId());
        return projectMapper.toDTO(projectService.postProject(project, currentUser));
    }

    /**
     * GET /api/projects{?page=}&{title=}&{difficulty=}&{description-}&{sort=}
     *
     * @see ProjectService#fetchAll(String, String, String, Pageable)
     */
    @GetMapping(produces = JSON)
    public Page<ProjectSummaryDTO> fetchAll(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "difficulty", required = false) String difficulty,
            @RequestParam(value = "description", required = false) String description,
            Pageable pageable) throws InvalidDifficultyException {

        return projectService.fetchAll(title, difficulty, description, pageable);
    }

    /**
     * GET /api/projects/:id
     *
     * @see ProjectService#fetchById(Long)
     */
    @GetMapping(value = "/{id:[\\d]}", produces = JSON)
    public ProjectDTO fetchById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectMapper.toDTO(projectService.fetchById(id));
    }

    /**
     * GET /api/projects/:id/comments{?page=}&{sort=}
     *
     * @see ProjectService#fetchCommentsByProjectId(Long, Pageable)
     */
    @GetMapping(value = "/{id}/comments", produces = JSON)
    public Page<CommentDTO> fetchComments(@PathVariable("id") Long id, Pageable pageable) {
        return projectService.fetchCommentsByProjectId(id, pageable).map(commentMapper::toDTO);
    }

    /**
     * POST /api/projects/:id/comments
     *
     * @see ProjectService#postComment(Comment, Long, User)
     */
    @PostMapping(value = "/{id}/comments", consumes = JSON, produces = JSON)
    public CommentDTO postComment(@PathVariable("id") Long projectId, @RequestBody Comment comment,
                                  @AuthenticationPrincipal User user) throws ExecutionException {
        comment.setId(null);
        timeOutService.handleTimeOut(user.getId());
        return commentMapper.toDTO(projectService.postComment(comment, projectId, user));
    }

    @PutMapping(value = "/{projectId}/comments/{commentId}", consumes = JSON, produces = JSON)
    public CommentDTO updateComment(@PathVariable("projectId") Long projectId,
                                    @PathVariable("commentId") Long commentId,
                                    @RequestBody Comment comment,
                                    @AuthenticationPrincipal User user) throws ExecutionException {
        timeOutService.handleTimeOut(user.getId());

        return commentMapper.toDTO(
                projectService.updateComment(comment, commentId, projectId, user)
        );
    }

    /**
     * DELETE /api/projects/:projectId/comments/:commentId
     *
     * @see ProjectService#deleteCommentById(Long, User)
     */
    @DeleteMapping(value = "/{projectId}/comments/{commentId}")
    public void deleteCommentById(@PathVariable("projectId") Long projectId,
                                  @PathVariable("commentId") Long commentId,
                                  @AuthenticationPrincipal User currentUser) {
        this.projectService.deleteCommentById(commentId, currentUser);
    }

    /**
     * PUT /api/projects/:id
     *
     * @see ProjectService#updateProject(Long, Project, User)
     */
    @PutMapping(value = "/{id}", consumes = JSON, produces = JSON)
    public ProjectDTO update(@PathVariable("id") Long id,
                             @RequestBody Project project,
                             @AuthenticationPrincipal User user) throws ExecutionException {
        timeOutService.handleTimeOut(user.getId());
        return projectMapper.toDTO(projectService.updateProject(id, project, user));
    }

    /**
     * DELETE /api/projects/:id
     *
     * @see ProjectService#deleteProjectById(Long, User)
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        projectService.deleteProjectById(id, user);
    }

}
