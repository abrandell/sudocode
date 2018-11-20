package org.sudocode.api.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ActiveProfiles;
import org.sudocode.api.core.exception.InvalidDifficultyException;
import org.sudocode.api.core.exception.NotPostAuthorException;
import org.sudocode.api.core.exception.ProjectNotFoundException;
import org.sudocode.api.core.security.AuthFacade;
import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.comment.CommentRepository;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.post.project.ProjectRepository;
import org.sudocode.api.user.User;
import testingutils.CommentViewMock;
import testingutils.ProjectViewMock;
import testingutils.UserViewMock;
import testingutils.ViewMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.sudocode.api.post.project.Difficulty.BASIC;
import static org.sudocode.api.post.project.Difficulty.INTERMEDIATE;

@MockitoSettings(strictness = Strictness.WARN)
@ActiveProfiles("test")
class PostingServiceUnitTests {

    @Mock
    private AuthFacade authMock;

    @Mock
    private ProjectRepository projectRepo;

    @Mock
    private CommentRepository commentRepo;

    @InjectMocks
    private PostingService service;

    private User user1;
    private User user2;

    private Project project1;
    private Project project2;

    private Comment comment1;
    private Comment comment2;

    private CommentViewMock commentViewMock1;
    private CommentViewMock commentViewMock2;

    private UserViewMock userViewMock1;
    private UserViewMock userViewMock2;

    private ProjectViewMock projectViewMock1;
    private ProjectViewMock projectViewMock2;

    @BeforeEach
    void setUp() {
        user1 = User.builder().id(1L).login("user-name-1").build();
        user2 = User.builder().id(2L).login("user-name-2").build();

        project1 = Project.builder(user1).id(1L).description("project-1 desc")
                          .difficulty(BASIC).title("project1-title").build();

        project2 = Project.builder(user2).id(2L).description("project-2 desc")
                          .difficulty(INTERMEDIATE).title("project2-title").build();

        comment1 = Comment.builder().id(1L).author(user1).body("comment-1 desc")
                          .project(project1).build();

        comment2 = Comment.builder().id(2L).author(user2).body("comment-2 desc")
                          .project(project1).build();

        userViewMock1 = ViewMapper.userToView(user1);
        userViewMock2 = ViewMapper.userToView(user2);

        projectViewMock1 = ViewMapper.projectToView(project1);
        projectViewMock2 = ViewMapper.projectToView(project2);

        commentViewMock1 = ViewMapper.commentToView(comment1);
        commentViewMock2 = ViewMapper.commentToView(comment2);

        given(projectRepo.fetchById(1L)).willReturn(Optional.of(project1));
        given(projectRepo.existsById(1L)).willReturn(true);
        given(projectRepo.save(project2)).willReturn(project2);

    }

    @Test
    void updateProject_notSameAuthor_thenPostNew() throws ExecutionException, InterruptedException {
        given(authMock.currentUser()).willReturn(user2);

        Project result = service.updateProject(project1.getId(), project2);

        assertAll("Update project -- not same author",
            () -> assertNotEquals(result.getTitle(), project1.getTitle(),
                "Should not of updated title"),
            () -> assertNotEquals(result.getDescription(), project1.getDescription(),
                "Should not of updated description"),
            () -> assertNotEquals(result.getId(), project1.getId(),
                "should not of replaced ID"),

            () -> verify(projectRepo, times(1)).fetchById(any()),
            () -> verify(projectRepo, times(1)).existsById(any()),
            () -> verify(projectRepo, times(1)).save(any(Project.class)),
            () -> verifyNoMoreInteractions(projectRepo)
        );
    }

    @Test
    void updateProject_sameAuthor_thenUpdate() throws ExecutionException, InterruptedException {
        given(authMock.currentUser()).willReturn(user1);

        final Project original = Project.builder(project1.getAuthor())
                                        .id(project1.getId())
                                        .description(project1.getDescription())
                                        .difficulty(project1.getDifficulty())
                                        .title(project1.getTitle())
                                        .build();

        Project result = service.updateProject(project1.getId(), project2);

        assertAll("Update project -- same author",
            () -> assertNotEquals(original.getTitle(), result.getTitle(),
                "Title should be updated"),
            () -> assertEquals(original.getId(), result.getId(),
                "ID's should match"),
            () -> assertNotEquals(original.getDescription(), result.getDescription(),
                "Description should update"),
            () -> assertNotEquals(original.getDifficulty(), result.getDifficulty(),
                "Difficulty should not match"),

            () -> verify(projectRepo, never()).save(any()),
            () -> verify(projectRepo, times(1)).fetchById(any()),
            () -> verifyNoMoreInteractions(projectRepo)
        );
    }

    @Test
    void deleteProjectById_sameAuthor_thenNoException() {
        given(authMock.currentUser()).willReturn(user2);
        given(projectRepo.fetchById(project2.getId())).willReturn(Optional.of(project2));

        assertAll("Delete project by id, same author",
            // Check that no exception thrown
            () -> service.deleteProjectById(project2.getId()),

            () -> verify(projectRepo, times(1)).fetchById(any()),
            () -> verify(commentRepo, times(1)).deleteCommentsByProjectId(any()),
            () -> verify(projectRepo, times(1)).delete(any()),
            () -> verifyNoMoreInteractions(projectRepo, commentRepo));
    }

    @Test
    void deleteProjectById_NotSameAuthor_thenException() {
        given(authMock.currentUser()).willReturn(user2);
        given(projectRepo.fetchById(project1.getId())).willReturn(Optional.of(project1));

        assertAll("Delete project by ID -- Not same author",
            () -> assertThrows(NotPostAuthorException.class,
                () -> service.deleteProjectById(project1.getId()),
                "Exception should be thrown"),

            () -> verify(projectRepo, times(1)).fetchById(any()),
            () -> verifyNoMoreInteractions(projectRepo),
            () -> verifyZeroInteractions(commentRepo));
    }

    @Test
    void postComment_giveKnownProjectId_thenSaveComment() {
        given(authMock.currentUser()).willReturn(user1);
        given(projectRepo.findById(1L)).willReturn(Optional.of(project1));
        given(commentRepo.save(comment1)).willReturn(comment1);

        Comment result = service.postComment(comment1, project1.getId());

        assertAll("Posting comment with project ID found",
            () -> assertNotNull(result, "Result should not be null"),
            () -> assertEquals(comment1, result, "Comment and result should equal"),

            () -> verify(commentRepo, times(1)).save(comment1),
            () -> verify(projectRepo, times(1)).findById(any()),
            () -> verifyNoMoreInteractions(commentRepo, projectRepo));
    }

    @Test
    void postComment_givenUnknownProjectId_ThenException() {
        assertAll("Posting comment with project ID not found",
            () -> assertThrows(ProjectNotFoundException.class,
                () -> service.postComment(comment1, -1L),
                "Exception should be thrown due to no project found from the given id"),

            () -> verify(commentRepo, never()).save(any()),
            () -> verify(projectRepo, times(1)).findById(any()),
            () -> verifyNoMoreInteractions(projectRepo, commentRepo));
    }

    @Test
    void fetchAllProjectViews() {
        given(projectRepo.filterAll(any(), any(), any(), any()))
            .willReturn(new PageImpl<>(List.of(projectViewMock1)));

        assertEquals(service.fetchAllProjectViews(null, null, null, null)
                            .getContent().get(0), projectViewMock1);
    }

    @Test
    void fetchAllComments() {
        given(commentRepo.fetchCommentViewsByProjectId(any(), any()))
            .willReturn(new PageImpl<>(List.of(commentViewMock1)));

        assertNotNull(service.fetchCommentViewsByProjectId(1L, null));
    }

    @Test
    void updateComment_sameAuthor_thenUpdate() {
        Long originalId = comment1.getId();
        final String originalCommentBody = comment1.getBody();
        given(authMock.currentUser()).willReturn(user1);
        given(commentRepo.fetchById(originalId)).willReturn(Optional.of(comment1));

        Comment newComment = Comment.builder().id(originalId).author(user1)
                                    .project(project1).body("new comment").build();

        Comment updated = service.updateComment(newComment, originalId,
            project1.getId());

        assertAll("Update comment -- same author",
            () -> assertEquals(comment1.getId(), updated.getId(),
                "ID's should match"),
            () -> assertEquals(user1, updated.getAuthor(), "Users should match"),
            () -> assertNotEquals(originalCommentBody, updated.getBody(),
                "Comment body should not match"),
            () -> assertEquals(newComment.getBody(), updated.getBody(),
                "Comment bodies should match."),
            () -> verify(commentRepo, times(1)).fetchById(originalId),
            () -> verify(commentRepo, times(0)).save(any()),
            () -> verifyZeroInteractions(projectRepo));
    }

    @Test
    void updateComment_notSameAuthor_thenPostNew() {
        Comment newComment = Comment.builder().body("updated comment").build();

        given(authMock.currentUser()).willReturn(user2);
        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));
        given(commentRepo.existsById(comment1.getId())).willReturn(true);
        given(projectRepo.findById(project1.getId())).willReturn(Optional.of(project1));
        given(commentRepo.save(newComment)).willReturn(newComment);

        var result = service.updateComment(newComment, comment1.getId(), project1.getId());

        assertAll("Update comment - not same author",
            () -> assertNotEquals(comment1.getBody(), result.getBody(),
                "Should not of updated comment body"),

            // No ID since not testing persistence
            () -> assertNull(result.getId(),
                "ID should be null. Make sure commentRepo.existsById was called before setting."),

            () -> assertEquals(project1, result.getProject(),
                "Make sure the project gets set in postComment"),

            () -> verify(commentRepo, times(1)).fetchById(comment1.getId()),
            () -> verify(commentRepo, times(1)).existsById(comment1.getId()),
            () -> verify(projectRepo, times(1)).findById(project1.getId()),
            () -> verify(commentRepo, times(1)).save(newComment),
            () -> verifyNoMoreInteractions(commentRepo, projectRepo));

    }

    @Test
    void deleteComment_notPostAuthor_thenException() {
        given(authMock.currentUser()).willReturn(user2);
        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));

        assertAll("Delete comment by id, not comment author",
            () -> assertThrows(NotPostAuthorException.class,
                () -> service.deleteCommentById(comment1.getId()),
                "Exception should be thrown since not comment author"),

            () -> verify(commentRepo, never()).delete(any()),
            () -> verify(commentRepo, times(1)).fetchById(comment1.getId()),
            () -> verifyNoMoreInteractions(commentRepo, projectRepo));
    }

    @Test
    void deleteComment_sameAuthor_theNoException() {
        given(authMock.currentUser()).willReturn(user1);
        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));

        assertAll("Delete comment by id, no exception",
            () -> service.deleteCommentById(comment1.getId()),

            () -> verify(commentRepo, times(1)).fetchById(comment1.getId()),
            () -> verify(commentRepo, times(1)).delete(comment1),
            () -> verifyNoMoreInteractions(commentRepo, projectRepo));
    }

    @Test
    void fetchLatestDate_lastPostAvailable() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime earlier = now.minusSeconds(30);

        given(projectRepo.lastPostDateByUserId(1L)).willReturn(Optional.of(now));
        given(commentRepo.lastPostDateByUserId(1L)).willReturn(Optional.of(earlier));

        assertEquals(now, service.fetchLatestPostDateByAuthorId(1L));
    }

    @Test
    void testFilterAll_invalidDifficulty_thenException() {
        assertThrows(InvalidDifficultyException.class,
            () -> service.fetchAllProjectViews(
                null, "invalid-diff", null, null
            )
        );
    }

    @Test
    void fetchAll_validDifficulty_noException() {
        service.fetchAllProjectViews(null, "   bAsIc", null, null);
    }
}

