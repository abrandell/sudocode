package org.sudocode.api.post.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.core.annotation.*;
import org.sudocode.api.core.exception.ProjectNotFoundException;
import org.sudocode.api.post.PostingService;
import org.sudocode.api.post.Vote;
import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.comment.CommentView;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.post.project.ProjectView;
import org.sudocode.api.user.User;

import java.util.Map;

/**
 * {@link RestController} for {@link Project} and {@link Comment} posts.
 */
@RestController
@RequestMapping("api/projects")
public final class PostingRestController {

    private final PostingService postingService;

    private final Logger logger = LoggerFactory.getLogger(PostingRestController.class);

    @Autowired
    public PostingRestController(PostingService postingService) {
        this.postingService = postingService;
    }

    /**
     * POST /api/projects
     *
     * @see PostingService#postProject(Project)
     */
    @PostJSON
    public Project postProject(@RequestBody Project project) {
        project.setId(null);
        return postingService.postProject(project);
    }

    /**
     * GET /api/projects{?page=}&{title=}&{difficulty=}&{description=}&{sort=}
     *
     * @see PostingService#fetchAllProjectViews(String, String, String, Pageable)
     */
    @GetJSON
    public Page<ProjectView> fetchProjects(@RequestParam Map<String, String> params,
                                           Pageable pageable) {

        return postingService.fetchAllProjectViews(
            params.get("title"),
            params.get("difficulty"),
            params.get("description"),
            pageable
        );
    }

    /**
     * POST /api/:id/vote?dir={UPVOTE, DOWNVOTE}
     * <p>
     * Upvote or downvote a project idea.
     */
    @PostJSON(path = "/{id}/vote")
    public void voteOnProject(@PathVariable("id") Long id,
                              @RequestParam("dir") Vote vote) {
        postingService.voteOnProject(vote, id);
    }

    /**
     * GET /api/projects/:id
     *
     * @see PostingService#fetchProjectViewById(Long) (Long)
     */
    @GetJSON(path = "/{id}")
    public ProjectView fetchProjectById(@PathVariable("id") Long id)
        throws ProjectNotFoundException {
        return postingService.fetchProjectViewById(id);
    }

    /**
     * GET /api/projects/:id/comments{?page=}&{sort=}
     */
    @GetJSON(path = "/{id}/comments")
    public Page<CommentView> fetchComments(@PathVariable("id") Long id,
                                           Pageable pageable) {
        return postingService.fetchCommentViewsByProjectId(id, pageable);
    }

    /**
     * POST /api/projects/:id/comments
     *
     * @see PostingService#postComment(Comment, Long, User)
     */
    @PostJSON(path = "/{id}/comments")
    public Comment postComment(@PathVariable("id") Long projectId,
                               @RequestBody Comment comment, @CurrentUser User user) {
        comment.setId(null);
        return postingService.postComment(comment, projectId, user);
    }

    @PutJSON(path = "/{projectId}/comments/{commentId}")
    public Comment updateComment(@PathVariable("projectId") Long projectId,
                                 @PathVariable("commentId") Long commentId, @RequestBody Comment comment,
                                 @CurrentUser User user) {

        return postingService.updateComment(comment, commentId, projectId, user);
    }

    /**
     * DELETE /api/projects/:projectId/comments/:commentId
     *
     * @see PostingService#deleteCommentById(Long, User)
     */
    @Delete(path = "/**/comments/{id}")
    public void deleteCommentById(@PathVariable("id") Long commentId, @CurrentUser User currentUser) {

        this.postingService.deleteCommentById(commentId, currentUser);
    }

    /**
     * PUT /api/projects/:id
     *
     * @see PostingService#updateProject(Long, Project, User)
     */
    @PutJSON(path = "/{id}")
    public Project updateProject(@PathVariable("id") Long id,
                                 @RequestBody Project project, @CurrentUser User user) {
        return postingService.updateProject(id, project, user);
    }

    /**
     * DELETE /api/projects/:id
     *
     * @see PostingService#deleteProjectById(Long, User)
     */
    @Delete(value = "/{id}")
    public void deleteProject(@PathVariable("id") Long id, @CurrentUser User user) {
        postingService.deleteProjectById(id, user);
    }

}
