package org.sudocode.api.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;

import java.util.*;
import java.util.concurrent.ExecutionException;

import static java.time.LocalDateTime.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @InjectMocks
    private ProjectService service;

    @Mock
    private ProjectRepository repo;
    @Mock
    private TimeOutService timeOutService;
    @Mock
    private UserService userService;
    @Mock
    private CommentRepository commentRepository;

    @Test
    void setUp() {
        User u = User.builder().id(1L).avatarUrl("lol").build();

        System.out.println(u.getAvatarUrl());
    }

    /*@Test
    void postProject() throws ExecutionException {
        User user = new User.Builder().id(1L).login("username").build();
        Project project = new Project(1L, "title", Difficulty.BASIC, "description", null);

        given(repo.save(project)).willReturn(project);

        assertNotNull(service.postProject(project, user));

    }

    @Test
    void postProjectDTO() throws ExecutionException {
        User user = new User.Builder().id(1L).login("username").build();
        Project project = new Project(1L, "title", Difficulty.BASIC, "description", null);

        given(repo.save(project)).willReturn(project);

        assertNotNull(service.postProjectDTO(project, user));
    }

    @Test
    void fetchAll() {
        var list = List.of(
                new ProjectSummaryDTO(
                        1L,
                        "title",
                        Difficulty.BASIC,
                        "desc",
                        now(),
                        1L,
                        "user",
                        null
                )
        );

        given(repo.fetchAll("t", Difficulty.BASIC, "desc", PageRequest.of(0, 20)))
                .willReturn(new PageImpl<>(list));

        assertNotNull(
                service.fetchAll("t", "basic", "desc", PageRequest.of(0, 20))
        );
    }

    @Test
    void fetchDTOById() {
        ProjectDTO dto = new ProjectDTO(new Project(1L, "title", Difficulty.BASIC, "desc",
                new User.Builder().id(1L).login("login").build()));

        given(repo.fetchDTOById(1L)).willReturn(Optional.of(dto));
        assertNotNull(service.fetchDTOById(1L));

    }

    @Test
    void update() throws ExecutionException {
        given(repo.existsById(1L)).willReturn(true);

        User u = new User.Builder().id(1L).login("login").build();
        Project p = new Project(1L, "t", Difficulty.BASIC, "desc", u);
        given(repo.getOne(1L)).willReturn(p);
        given(userService.currentUser()).willReturn(u);

        assertNotNull(service.update(1L, p));
    }


    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void postComment() throws ExecutionException {
        User u = new User.Builder().id(1L).build();
        Project p = new Project(1L, "title", Difficulty.BASIC, "desc", u);
        Comment c = new Comment(1L, p, "body", u, null);

        given(repo.findById(1L)).willReturn(Optional.of(p));
        given(commentRepository.save(c)).willReturn(c);

        assertNotNull(service.postComment(c, 1L, u));
    }

    @Test
    void deleteCommentById() {
        User user = new User.Builder().id(1L).login("username").build();
        Project project = new Project(1L, "title", Difficulty.BASIC, "desc", user);
        Comment comment = new Comment(1L, project, "body", user, null);

        given(userService.currentUser()).willReturn(user);
        given(commentRepository.fetchById(1L)).willReturn(Optional.of(comment));

        // No exception thrown
        service.deleteCommentById(1L);

    }

    @Test
    void fetchCommentsByProjectId() {
        List<CommentDTO> dtoList = List.of(
                new CommentDTO(1L, "comment-body",
                        now().minusSeconds(50), now(), 1L,
                        "username", "avatar-url", true)
        );

        given(commentRepository.fetchCommentPageDTOByProjectId(1L, PageRequest.of(1, 20)))
                .willReturn(new PageImpl<>(dtoList));

        assertNotNull(service.fetchCommentsByProjectId(1L, PageRequest.of(1, 20)));

    }

    @Test
    void updateComment() {

    }*/
}