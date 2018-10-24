package org.sudocode.api.project.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;
import org.sudocode.api.core.exceptions.ProjectNotFoundException;
import org.sudocode.api.core.security.CurrentUser;
import org.sudocode.api.project.Project;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.user.User;

import java.util.concurrent.ExecutionException;

import static org.sudocode.api.core.util.Constants.JSON;


/**
 * RestController for {@link Project}.
 */
@RestController
@RequestMapping("api/projects")
public final class ProjectRestController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;
    private final CommentMapper commentMapper;
    private final Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    public ProjectRestController(ProjectService projectService,
                                 ProjectMapper projectMapper, CommentMapper commentMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.commentMapper = commentMapper;
    }

    /**
     * POST /api/projects
     *
     * @see ProjectService#postProject(Project, User)
     */
    @PostMapping(consumes = JSON, produces = JSON)
    public ProjectDTO post(@RequestBody Project project, @CurrentUser User currentUser) {
        project.setId(null);
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
    @GetMapping(value = "/{id}", produces = JSON)
    public Project fetchById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectService.fetchById(id);
    }

    /**
     * GET /api/projects/:id/comments{?page=}&{sort=}
     *
     * @see ProjectService#fetchCommentsByProjectId(Long, Pageable)
     */
    @GetMapping(value = "/{id}/comments", produces = JSON)
    public Page<CommentDTO> fetchComments(@PathVariable("id") Long id, Pageable pageable) {
        return projectService.fetchCommentsByProjectId(id, pageable).map(CommentDTO::new);
    }

    /**
     * POST /api/projects/:id/comments
     *
     * @see ProjectService#postComment(Comment, Long, User)
     */
    @PostMapping(value = "/{id}/comments", consumes = JSON, produces = JSON)
    public CommentDTO postComment(@PathVariable("id") Long projectId, @RequestBody Comment comment,
                                  @CurrentUser User user) throws ExecutionException {
        comment.setId(null);
        return commentMapper.toDTO(projectService.postComment(comment, projectId, user));
    }

    @PutMapping(value = "/{projectId}/comments/{commentId}", consumes = JSON, produces = JSON)
    public CommentDTO updateComment(@PathVariable("projectId") Long projectId,
                                    @PathVariable("commentId") Long commentId,
                                    @RequestBody Comment comment,
                                    @CurrentUser User user) throws ExecutionException {

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
                                  @CurrentUser User currentUser) {
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
                             @CurrentUser User user) throws ExecutionException {
        return projectMapper.toDTO(projectService.updateProject(id, project, user));
    }

    /**
     * DELETE /api/projects/:id
     *
     * @see ProjectService#deleteProjectById(Long, User)
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id, @CurrentUser User user) {
        projectService.deleteProjectById(id, user);
    }

}
