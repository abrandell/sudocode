package org.sudocode.api.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;
import org.sudocode.api.core.exceptions.NotPostAuthorException;
import org.sudocode.api.core.exceptions.ProjectNotFoundException;
import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.comment.CommentRepository;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.post.project.ProjectRepository;
import org.sudocode.api.post.project.ProjectView;
import org.sudocode.api.user.User;
import testingutils.CommentViewMock;
import testingutils.ProjectViewMock;
import testingutils.UserViewMock;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.MIN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.data.domain.Pageable.*;
import static org.sudocode.api.post.project.Difficulty.BASIC;
import static org.sudocode.api.post.project.Difficulty.EXPERT;
import static org.sudocode.api.post.project.Difficulty.INTERMEDIATE;

@ExtendWith(MockitoExtension.class)
class PostingServiceTest {

    @InjectMocks
    private PostingService postingService;

    @Mock
    private ProjectRepository projectRepo;

    @Mock
    private CommentRepository commentRepo;

    private User user1;
    private UserViewMock userViewMock1;
    private User user2;

    private Project project1;
    private ProjectViewMock projectViewMock1;
    private Project project2;

    private Comment comment1;
    private CommentViewMock commentViewMock1;
    private Comment comment2;


    @BeforeEach
    void setUp() {
        user1 = User.builder().id(1L).login("user-name-1").build();
        userViewMock1 = UserViewMock.builder().id(1L).login(user1.getLogin()).build();
        user2 = User.builder().id(2L).login("user-name-2").build();

        project1 = Project.builder(user1).id(1L).description("project-1 desc")
                          .difficulty(BASIC).title("project1-title").build();
        projectViewMock1 = ProjectViewMock.builder().author(userViewMock1).id(1L)
                                          .description(project1.getDescription())
                                          .difficulty(project1.getDifficulty()).build();

        project2 = Project.builder(user2).id(2L).description("project-2 desc")
                          .difficulty(INTERMEDIATE).title("project2-title").build();

        comment1 = Comment.builder().id(1L).author(user1).body("comment-1 desc").project(project1).build();
        commentViewMock1 = CommentViewMock.builder().id(1L).author(userViewMock1).body(comment1.getBody()).build();
        comment2 = Comment.builder().id(2L).author(user2).body("comment-2 desc").project(project1).build();
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void updateProject_notSameAuthor_thenPostNew() {
        given(projectRepo.fetchById(project1.getId())).willReturn(Optional.of(project1));
        given(projectRepo.existsById(project1.getId())).willReturn(true);
        given(projectRepo.save(any(Project.class))).willReturn(project2);

        Project result = postingService.updateProject(project1.getId(), project2, user2);

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
                () -> verifyNoMoreInteractions(projectRepo),
                () -> verifyZeroInteractions(commentRepo)
        );
    }


    @SuppressWarnings("ConstantConditions")
    @Test
    void updatedProject_sameAuthor_thenUpdate() {
        given(projectRepo.fetchById(project1.getId())).willReturn(Optional.of(project1));

        Project updated = Project.builder(user1).id(project1.getId()).title("updated-title").difficulty(EXPERT).build();


        postingService.updateProject(project1.getId(), updated, user1);

        assertAll("Update project -- same author",
                () -> assertEquals(project1.getTitle(), updated.getTitle(),
                        "Project title should be updated"),
                () -> assertEquals(project1.getDescription(), updated.getDescription(),
                        "Project description should be updated."),
                () -> assertEquals(project1.getDifficulty(), updated.getDifficulty(),
                        "Difficulty should be updated"),

                () -> verify(projectRepo, times(1)).fetchById(any()),
                () -> verifyNoMoreInteractions(projectRepo)
        );

    }

    @Test
    void fetchAllProjectViews() {
        given(projectRepo.filterAll(any(), any(), any(), any())).willReturn(new PageImpl<>(List.of(projectViewMock1)));

        assertEquals(
                postingService.fetchAllProjectViews(null, null, null, null)
                              .getContent().get(0), projectViewMock1
        );
    }

    @Test
    void fetchAllComments() {
        given(commentRepo.fetchCommentViewsByProjectId(any(), any())).willReturn(new PageImpl<>(List.of(commentViewMock1)));

        assertNotNull(postingService.fetchCommentViewsByProjectId(1L, null));
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void fetchProjectViewById() {
        given(projectRepo.findViewById(project1.getId())).willReturn(Optional.of(projectViewMock1));
        given(projectRepo.findViewById(-1L)).willReturn(Optional.empty());

        ProjectView found = postingService.fetchProjectViewById(project1.getId());

        assertAll("Fetch view by id",
                () -> assertEquals(found.getDifficulty(), projectViewMock1.getDifficulty(),
                        "Difficulties should match"),
                () -> assertThrows(ProjectNotFoundException.class,
                        () -> postingService.fetchProjectViewById(-1L), "Should throw Exception")
        );
    }

    @Test
    void updateProject_sameAuthor_thenUpdate() {
        final Long originalId = this.project1.getId();

        final Project original = Project.builder(project1.getAuthor())
                                        .id(project1.getId())
                                        .description(project1.getDescription())
                                        .difficulty(project1.getDifficulty())
                                        .title(project1.getTitle()).build();

        given(projectRepo.fetchById(originalId)).willReturn(Optional.of(this.project1));

        final Project result = postingService.updateProject(
                originalId,
                Project.builder(user1).title("new title").description("new description").difficulty(EXPERT).build(),
                this.user1
        );

        assertAll("Project update -- same author",
                () -> assertEquals(original.getId(), result.getId(),
                        "ID's should match."),
                () -> assertEquals(user1, result.getAuthor(),
                        "Users should match"),
                () -> assertNotEquals(original.getDescription(), result.getDescription(),
                        "Description should update"),
                () -> assertNotEquals(original.getDifficulty(), result.getDifficulty(),
                        "Difficulty should not match"),
                () -> assertNotEquals(original.getTitle(), result.getTitle(),
                        "Title should update"),

                () -> verify(projectRepo, never()).save(any()),
                () -> verify(projectRepo, times(1)).fetchById(any()),
                () -> verifyNoMoreInteractions(projectRepo),
                () -> verifyZeroInteractions(commentRepo)
        );
    }

    @Test
    void postComment_givenUnknownProjectId_ThenException() {
        given(commentRepo.existsById(any())).willReturn(false);

        assertAll("Posting comment with project ID not found",
                () -> assertThrows(ProjectNotFoundException.class,
                        () -> postingService.postComment(comment1, 20L, user1),
                        "Exception should be thrown due to no project found from the given id"),

                () -> verify(commentRepo, never()).save(any()),
                () -> verify(commentRepo, times(1)).existsById(any()),
                () -> verify(projectRepo, times(1)).findById(any()),
                () -> verifyNoMoreInteractions(projectRepo, commentRepo)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void postComment_giveKnownProjectId_thenSaveComment() {
        given(commentRepo.existsById(any())).willReturn(false);
        given(projectRepo.findById(project1.getId())).willReturn(Optional.of(project1));
        given(commentRepo.save(comment1)).willReturn(comment1);


        Comment result = postingService.postComment(comment1, project1.getId(), user1);

        assertAll("Posting comment with project ID found",
                () -> assertNotNull(result, "Result should not be null"),
                () -> assertEquals(comment1, result, "Comment and result should equal"),

                () -> verify(commentRepo, times(1)).existsById(comment1.getId()),
                () -> verify(projectRepo, times(1)).findById(project1.getId()),
                () -> verify(commentRepo, times(1)).save(comment1),
                () -> verifyNoMoreInteractions(commentRepo, projectRepo)
        );
    }

    @Test
    void deleteProjectById_sameAuthor_thenNoException() {
        given(projectRepo.fetchById(project2.getId())).willReturn(Optional.of(project2));

        assertAll("Delete project by id, same author",
                // Check that no exception thrown
                () -> postingService.deleteProjectById(project2.getId(), user2),

                () -> verify(projectRepo, times(1)).fetchById(any()),
                () -> verify(commentRepo, times(1)).deleteCommentsByProjectId(any()),
                () -> verify(projectRepo, times(1)).delete(any()),
                () -> verifyNoMoreInteractions(projectRepo, commentRepo)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void updateComment_notSameAuthor_thenPostNew() {
        Comment newComment = Comment.builder().body("updated comment").build();

        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));
        given(commentRepo.existsById(comment1.getId())).willReturn(true);
        given(projectRepo.findById(project1.getId())).willReturn(Optional.of(project1));
        given(commentRepo.save(newComment)).willReturn(newComment);

        var result = postingService.updateComment(newComment, comment1.getId(), project1.getId(), user2);

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
                () -> verifyNoMoreInteractions(commentRepo, projectRepo)
        );

    }

    @Test
    void deleteProjectById_NotSameAuthor_thenException() {
        given(projectRepo.fetchById(project1.getId())).willReturn(Optional.of(project1));

        assertAll("Delete project by ID -- Not same author",
                () -> assertThrows(NotPostAuthorException.class,
                        () -> postingService.deleteProjectById(project1.getId(), user2),
                        "Exception should be thrown"),

                () -> verify(projectRepo, times(1)).fetchById(any()),
                () -> verifyNoMoreInteractions(projectRepo),
                () -> verifyZeroInteractions(commentRepo)
        );
    }


    @Test
    void updateComment_sameAuthor_thenUpdate() {
        Long originalId = comment1.getId();
        final String originalCommentBody = comment1.getBody();
        given(commentRepo.fetchById(originalId)).willReturn(Optional.of(comment1));

        Comment newComment = Comment.builder().id(originalId).author(user1).project(project1)
                                    .body("new comment").build();

        Comment updated = postingService.updateComment(newComment, originalId, project1.getId(), user1);


        assertAll("Update comment -- same author",
                () -> assertEquals(comment1.getId(), updated.getId(),
                        "ID's should match"),
                () -> assertEquals(user1, updated.getAuthor(),
                        "Users should match"),
                () -> assertNotEquals(originalCommentBody, updated.getBody(),
                        "Comment body should not match"),
                () -> assertEquals(newComment.getBody(), updated.getBody(),
                        "Comment bodies should match."),
                () -> verify(commentRepo, times(1)).fetchById(originalId),
                () -> verify(commentRepo, times(0)).save(any()),
                () -> verifyZeroInteractions(projectRepo)
        );
    }

    @Test
    void deleteComment_notPostAuthor_thenException() {
        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));

        assertAll("Delete comment by id, not comment author",
                () -> assertThrows(NotPostAuthorException.class,
                        () -> postingService.deleteCommentById(comment1.getId(), user2),
                        "Exception should be thrown since not comment author"),

                () -> verify(commentRepo, never()).delete(any()),
                () -> verify(commentRepo, times(1)).fetchById(comment1.getId()),
                () -> verifyNoMoreInteractions(commentRepo, projectRepo)
        );
    }

    @Test
    void deleteComment_sameAuthor_theNoException() {
        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));

        assertAll("Delete comment by id, no exception",
                () -> postingService.deleteCommentById(comment1.getId(), user1),

                () -> verify(commentRepo, times(1)).fetchById(comment1.getId()),
                () -> verify(commentRepo, times(1)).delete(comment1),
                () -> verifyNoMoreInteractions(commentRepo, projectRepo)
        );
    }



    @Test
    void fetchLatestPostDateByAuthorId_noLastPost() {
        given(projectRepo.fetchLatestPostDateByAuthorId(any())).willReturn(Optional.empty());
        given(commentRepo.fetchLatestPostDateByAuthorId(any())).willReturn(Optional.empty());

        assertEquals(MIN, postingService.fetchLatestPostDateByAuthorId(1L));
    }

    @Test
    void fetchLatestDate_lastPostAvailable() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime earlier = now.minusSeconds(30);

        given(projectRepo.fetchLatestPostDateByAuthorId(1L)).willReturn(Optional.of(now));
        given(commentRepo.fetchLatestPostDateByAuthorId(1L)).willReturn(Optional.of(earlier));

        assertEquals(now, postingService.fetchLatestPostDateByAuthorId(1L));
    }

    @Test
    void testFilterAll_invalidDifficulty_thenException() {
        assertThrows(InvalidDifficultyException.class,
                () -> postingService.fetchAllProjectViews(
                        null, "invalid-diff", null, null
                )
        );
    }

    @Test
    void postProject_setsIdNull() {
        given(projectRepo.save(any(Project.class))).willReturn(project1);
        assertNull(postingService.postProject(project1).getId(), "Should set ID to null");
    }

    @Test
    void fetchAll_validDifficulty_noException() {
        postingService.fetchAllProjectViews(null, "bAsIc", null, null);
    }
}