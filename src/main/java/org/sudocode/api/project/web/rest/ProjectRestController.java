package org.sudocode.api.project.web.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.project.*;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.web.ProjectDTO;
import org.sudocode.api.project.web.ProjectMapper;
import org.sudocode.api.project.web.ProjectSummaryDTO;
import org.sudocode.api.user.domain.User;

import java.util.concurrent.ExecutionException;

import static org.sudocode.api.core.util.Constants.*;


/**
 * RestController for {@link org.sudocode.api.project.domain.Project}.
 */
@RestController
@RequestMapping("api/projects")
public final class ProjectRestController {

    private final ProjectService service;
    private final ProjectMapper projectMapper;
    private final CommentMapper commentMapper;
    private final Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    public ProjectRestController(ProjectService service, ProjectMapper projectMapper, CommentMapper commentMapper) {
        this.service = service;
        this.projectMapper = projectMapper;
        this.commentMapper = commentMapper;
    }

    /**
     * POST /api/projects
     *
     * @see ProjectService#postProject(Project, User)
     */
    @PostMapping(consumes = JSON, produces = JSON)
    public ProjectDTO post(@RequestBody Project project,
                           @AuthenticationPrincipal User currentUser) throws ExecutionException {
        return projectMapper.toDTO(service.postProject(project, currentUser));
    }

    /**
     * GET /api/projects{?page=}&{title=}&{difficulty=}&{description-}&{sort=}
     *
     * @see ProjectService#fetchAll(String, String, String, Pageable)
     */
    @GetMapping(produces = JSON)
    public Page<ProjectSummaryDTO> fetchAll(@RequestParam(value = "title", defaultValue = "") String title,
                                            @RequestParam(value = "difficulty", defaultValue = "") String difficulty,
                                            @RequestParam(value = "description", defaultValue = "") String description,
                                            Pageable pageable) throws InvalidDifficultyException {

        return service.fetchAll(title, difficulty, description, pageable);
    }

    /**
     * GET /api/projects/:id
     *
     * @see ProjectService#fetchById(Long)
     */
    @GetMapping(value = "/{id:[\\d]}", produces = JSON)
    public ProjectDTO fetchById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectMapper.toDTO(service.fetchById(id));
    }

    /**
     * GET /api/projects/:id/comments{?page=}&{sort=}
     *
     * @see ProjectService#fetchCommentsByProjectId(Long, Pageable)
     */
    @GetMapping(value = "/{id}/comments", produces = JSON)
    public Page<CommentDTO> fetchComments(@PathVariable("id") Long id, Pageable pageable) {
        return service.fetchCommentsByProjectId(id, pageable).map(commentMapper::toDTO);
    }

    /**
     * POST /api/projects/:id/comments
     *
     * @see ProjectService#postComment(Comment, Long, User)
     */
    @PostMapping(value = "/{id}/comments", consumes = JSON, produces = JSON)
    public CommentDTO postComment(@PathVariable("id") Long projectId,
                                  @RequestBody Comment comment,
                                  @AuthenticationPrincipal User user) throws ExecutionException {

        return commentMapper.toDTO(service.postComment(comment, projectId, user));
    }

    @PutMapping(value = "/{projectId}/comments/{commentId}", consumes = JSON, produces = JSON)
    public CommentDTO updateComment(@PathVariable("projectId") Long projectId,
                                    @PathVariable("commentId") Long commentId,
                                    @RequestBody Comment comment,
                                    @AuthenticationPrincipal User user) throws ExecutionException {

        return commentMapper.toDTO(service.updateComment(comment, commentId, projectId, user));
    }

    /**
     * DELETE /api/projects/:projectId/comments/:commentId
     *
     * @see ProjectService#deleteCommentById(Long)
     */
    @DeleteMapping(value = "/{projectId}/comments/{commentId}")
    public void deleteCommentById(@PathVariable("projectId") Long projectId,
                                  @PathVariable("commentId") Long commentId) {
        this.service.deleteCommentById(commentId);
    }

    /**
     * PUT /api/projects/:id
     *
     * @see ProjectService#update(Long, Project, User)
     */
    @PutMapping(value = "/{id}", consumes = JSON, produces = JSON)
    public ProjectDTO update(@PathVariable("id") Long id,
                             @RequestBody Project project,
                             @AuthenticationPrincipal User user) throws ExecutionException {

        return projectMapper.toDTO(service.update(id, project, user));
    }

    /**
     * DELETE /api/projects/:id
     *
     * @see ProjectService#deleteById(Long, User) d(Long)
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        service.deleteById(id, user);
    }

}
