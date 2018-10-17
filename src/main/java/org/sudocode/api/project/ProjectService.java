package org.sudocode.api.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.web.CommentForm;
import org.sudocode.api.project.web.ProjectPostForm;
import org.sudocode.api.user.domain.User;

import java.util.concurrent.ExecutionException;

public interface ProjectService {

    Project postProject(ProjectPostForm postForm, User currentUser) throws ExecutionException;

    ProjectDTO postProjectDTO(ProjectPostForm postForm, User currentUser) throws ExecutionException;

    Page<ProjectSummaryDTO> fetchAll(@Nullable String title,
                                     @Nullable String difficulty,
                                     @Nullable String description,
                                     Pageable pageable);

    ProjectDTO fetchDTOById(Long id) throws ProjectNotFoundException;

    ProjectDTO update(Long id, ProjectPostForm postForm) throws NotPostAuthorException, ExecutionException;

    void deleteById(Long id) throws NotPostAuthorException;

    CommentDTO postComment(CommentForm form, Long projectId, User currentUser) throws ExecutionException;


    void deleteCommentById(Long id) throws NotPostAuthorException;

    Page<CommentDTO> fetchCommentsByProjectId(Long id, Pageable pageable);



}
