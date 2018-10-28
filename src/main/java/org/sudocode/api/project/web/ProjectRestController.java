package org.sudocode.api.project.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;
import org.sudocode.api.core.exceptions.ProjectNotFoundException;
import org.sudocode.api.core.security.CurrentUser;
import org.sudocode.api.project.Project;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentView;
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
    private final Logger logger = LoggerFactory.getLogger(ProjectRestController.class);

    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * POST /api/projects
     *
     * @see ProjectService#postProject(Project)
     */
    @PostMapping(consumes = JSON, produces = JSON)
    public Project post(@RequestBody Project project) {
        project.setId(null);
        return projectService.postProject(project);
    }

    /**
     * GET /api/projects{?page=}&{title=}&{difficulty=}&{description-}&{sort=}
     *
     * @see ProjectService#fetchAll(String, String, String, Pageable)
     */
    @GetMapping(produces = JSON)
    public Page<ProjectView> fetchAll(
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
    public ProjectView fetchById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectService.fetchById(id);
    }

    /**
     * GET /api/projects/:id/comments{?page=}&{sort=}
     */
    @GetMapping(value = "/{id}/comments", produces = JSON)
    public Page<CommentView> fetchComments(@PathVariable("id") Long id, Pageable pageable) {
        return projectService.fetchCommentViewsByProjectId(id, pageable);
    }

    /**
     * POST /api/projects/:id/comments
     *
     * @see ProjectService#postComment(Comment, Long, User)
     */
    @PostMapping(value = "/{id}/comments", consumes = JSON, produces = JSON)
    public Comment postComment(@PathVariable("id") Long projectId,
                               @RequestBody Comment comment,
                               @CurrentUser User user) {
        comment.setId(null);
        return projectService.postComment(comment, projectId, user);
    }

    @PutMapping(value = "/{projectId}/comments/{commentId}", consumes = JSON, produces = JSON)
    public Comment updateComment(@PathVariable("projectId") Long projectId,
                                    @PathVariable("commentId") Long commentId,
                                    @RequestBody Comment comment,
                                    @CurrentUser User user) {

        return projectService.updateComment(comment, commentId, projectId, user);
    }

    /**
     * DELETE /api/projects/:projectId/comments/:commentId
     *
     * @see ProjectService#deleteCommentById(Long, User)
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
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
    public Project updateProject(@PathVariable("id") Long id,
                                 @RequestBody Project project, @CurrentUser User user) {
        return projectService.updateProject(id, project, user);
    }

    /**
     * DELETE /api/projects/:id
     *
     * @see ProjectService#deleteProjectById(Long, User)
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id, @CurrentUser User user) {
        projectService.deleteProjectById(id, user);
    }
}
