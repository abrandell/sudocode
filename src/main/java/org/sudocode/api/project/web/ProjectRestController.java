package org.sudocode.api.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentForm;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.ProjectNotFoundException;
import org.sudocode.api.project.dto.ProjectDTO;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.dto.ProjectSummary;


import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("api/projects")
public final class ProjectRestController {

    private final ProjectService projectService;
    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProjectDTO post(@RequestBody ProjectPost projectPost) {
        return projectService.post(projectPost);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<ProjectSummary> fetchAll(@RequestParam(value = "title", required = false) String title,
                                         @RequestParam(value = "difficulty", required = false) String difficulty,
                                         @RequestParam(value = "description", required = false) String description,
                                         Pageable pageable) throws InvalidDifficultyException {

        return projectService.fetchAll(title, difficulty, description, pageable);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ProjectDTO fetchById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectService.fetchById(id);
    }

    @GetMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public Page<CommentDTO> fetchComments(@PathVariable("id") Long id, Pageable pageable) {
        return projectService.fetchCommentsByProjectId(id, pageable);
    }

    @PostMapping(value = "/{id}/comments", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CommentDTO postComment(@PathVariable("id") Long projectId, @RequestBody CommentForm commentForm) {
        System.out.println(commentForm);
        return projectService.postComment(commentForm, projectId);
    }

    @DeleteMapping(value = "/{projectId}/comments/{commentId}")
    public void deleteCommentById(@PathVariable("projectId") Long projectId,
                                  @PathVariable("commentId") Long commentId) {
        this.projectService.deleteCommentById(commentId);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProjectDTO update(@PathVariable("id") Long id, @RequestBody ProjectPost projectPostform) {
        return projectService.update(id, projectPostform);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        projectService.deleteById(id);
    }

}
