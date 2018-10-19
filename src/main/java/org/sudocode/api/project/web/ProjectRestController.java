package org.sudocode.api.project.web;

import com.google.common.base.Preconditions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.ProjectNotFoundException;
import org.sudocode.api.project.ProjectDTO;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.ProjectSummaryDTO;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.domain.User;

import java.util.concurrent.ExecutionException;

import static org.springframework.http.MediaType.*;


/**
 * RestController for {@link org.sudocode.api.project.domain.Project}.
 */
@RestController
@RequestMapping("api/projects")
public final class ProjectRestController {

    private final ProjectService projectService;
    private final Log LOG = LogFactory.getLog(ProjectRestController.class);

    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * POST /api/projects
     *
     * @see ProjectService#postProjectDTO(Project, User)
     */
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProjectDTO post(@RequestBody Project project,
                           @AuthenticationPrincipal User currentUser) throws ExecutionException {
        return projectService.postProjectDTO(project, currentUser);
    }

    /**
     * GET /api/projects{?page=}&{title=}&{difficulty=}&{description-}&{sort=}
     *
     * @see ProjectService#fetchAll(String, String, String, Pageable)
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<ProjectSummaryDTO> fetchAll(@RequestParam(value = "title", required = false) String title,
                                            @RequestParam(value = "difficulty", required = false) String difficulty,
                                            @RequestParam(value = "description", required = false) String description,
                                            Pageable pageable) throws InvalidDifficultyException {

        return projectService.fetchAll(title, difficulty, description, pageable);
    }

    /**
     * GET /api/projects/:id
     *
     * @see ProjectService#fetchDTOById(Long)
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ProjectDTO fetchById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectService.fetchDTOById(id);
    }

    /**
     * GET /api/projects/:id/comments{?page=}&{sort=}
     *
     * @see ProjectService#fetchCommentsByProjectId(Long, Pageable)
     */
    @GetMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public Page<CommentDTO> fetchComments(@PathVariable("id") Long id, Pageable pageable) {
        return projectService.fetchCommentsByProjectId(id, pageable);
    }

    /**
     * POST /api/projects/:id/comments
     *
     * @see ProjectService#postComment(Comment, Long, User)
     */
    @PostMapping(value = "/{id}/comments", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CommentDTO postComment(@PathVariable("id") Long projectId,
                                  @RequestBody Comment comment,
                                  @AuthenticationPrincipal User user) throws ExecutionException {

        return new CommentDTO(projectService.postComment(comment, projectId, user));
    }

    /**
     * DELETE /api/projects/:projectId/comments/:commentId
     *
     * @see ProjectService#deleteCommentById(Long)
     */
    @DeleteMapping(value = "/{projectId}/comments/{commentId}")
    public void deleteCommentById(@PathVariable("projectId") Long projectId,
                                  @PathVariable("commentId") Long commentId) {
        this.projectService.deleteCommentById(commentId);
    }

    /**
     * PUT /api/projects/:id
     *
     * @see ProjectService#update(Long, Project)
     */
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProjectDTO update(@PathVariable("id") Long id,
                             @RequestBody Project project) throws ExecutionException {
        Preconditions.checkNotNull(project);
        return projectService.update(id, project);
    }

    /**
     * DELETE /api/projects/:id
     *
     * @see ProjectService#deleteById(Long)
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        projectService.deleteById(id);
    }

}
