package org.sudocode.api.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;
import org.sudocode.api.core.exceptions.NotPostAuthorException;
import org.sudocode.api.core.exceptions.ProjectNotFoundException;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.user.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.sudocode.api.project.Difficulty.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProjectServiceTest {

    private final Logger logger = LoggerFactory.getLogger(ProjectServiceTest.class);

    @InjectMocks
    private ProjectService service;

    @Mock
    private ProjectRepository projectRepo;
    @Mock
    private CommentRepository commentRepo;

    private User user1;
    private User user2;

    private Project project1;
    private Project project2;
    private Comment comment1;
    private Comment comment2;

    @BeforeEach
    void setUp() {
        user1 = User.builder().id(1L).login("user-name-1").build();
        user2 = User.builder().id(2L).login("user-name-2").build();

        project1 = Project.builder(user1).id(1L).description("project-1 desc")
                          .difficulty(BASIC).title("project1-title").build();

        project2 = Project.builder(user2).id(2L).description("project-2 desc")
                          .difficulty(INTERMEDIATE).title("project2-title").build();

        comment1 = Comment.builder().id(1L).author(user1).body("comment-1 desc").project(project1).build();
        comment2 = Comment.builder().id(2L).author(user2).body("comment-2 desc").project(project1).build();

    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void updateComment_notSameAuthor_thenPostNew() {
        Comment newComment = Comment.builder().body("updated comment").build();

        given(commentRepo.fetchById(comment1.getId())).willReturn(Optional.of(comment1));
        given(commentRepo.existsById(comment1.getId())).willReturn(true);
        given(projectRepo.findById(project1.getId())).willReturn(Optional.of(project1));
        given(commentRepo.save(newComment)).willReturn(newComment);

        var result = service.updateComment(newComment, comment1.getId(), project1.getId(), user2);

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
                () -> verify(projectRepo, times(1)).findById(project1.getId())
        );

    }

    @Test
    void fetchById() {
        given(projectRepo.fetchById(project1.getId())).willReturn(Optional.of(project1));
        assertEquals(project1, service.fetchById(project1.getId()));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void updateProject_notSameAuthor_thenPostNew() {
        Long projectId = project1.getId();
        project2.setAuthor(null);

        given(projectRepo.fetchById(projectId)).willReturn(Optional.of(project1));
        given(projectRepo.existsById(projectId)).willReturn(true);
        given(projectRepo.save(project2)).willReturn(project2);

        Project result = service.updateProject(projectId, project2, user2);

        assertAll("Project update -- diff author",
                () -> assertNotEquals(result.getId(), project1.getId(),
                        "project2 should not replace project1 due to different posters" +
                                "\n\n" + result.toString() + "\n\n" + project1),

                () -> verify(projectRepo, times(1)).fetchById(projectId),
                () -> verify(projectRepo, times(1)).save(project2),
                () -> verify(projectRepo, times(1)).existsById(projectId),
                () -> verifyNoMoreInteractions(projectRepo, commentRepo)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void updateProject_sameAuthor_thenUpdate() {
        final Long originalId = this.project1.getId();

        given(projectRepo.fetchById(originalId)).willReturn(Optional.of(this.project1));

        Project result = service.updateProject(
                originalId,
                Project.builder(user1).description("new description").difficulty(EXPERT).build(),
                this.user1
        );

        assertAll("Project update -- same author",
                () -> assertEquals(project1.getId(), result.getId(),
                        "ID's should match."),
                () -> assertEquals(user1, result.getAuthor(),
                        "Users should match"),
                () -> assertEquals(project1.getDescription(), result.getDescription(),
                        "Desc should match"),
                () -> assertNotEquals(project1.getDescription(), result.getDifficulty(),
                        "Difficulty should not match"),
                () -> verify(projectRepo, never()).save(any()),
                () -> verify(projectRepo, times(1)).fetchById(originalId),
                () -> verifyNoMoreInteractions(projectRepo),
                () -> verifyZeroInteractions(commentRepo)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void deleteProjectById_sameAuthor_thenNoException() {
        given(projectRepo.fetchById(project2.getId())).willReturn(Optional.of(project2));

        assertAll("Delete project by id, same author",
                // Check that no exception thrown
                () -> service.deleteProjectById(project2.getId(), user2),

                () -> verify(projectRepo, times(1)).fetchById(any()),
                () -> verify(commentRepo, times(1)).deleteCommentsByProjectId(any()),
                () -> verify(projectRepo, times(1)).delete(any()),
                () -> verifyNoMoreInteractions(projectRepo, commentRepo)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void deleteProjectById_notSameAuthor_thenException() {
        given(projectRepo.fetchById(project1.getId())).willReturn(Optional.of(project1));

        assertAll("Delete comment by - not same author",
                () -> assertThrows(NotPostAuthorException.class,
                        () -> service.deleteProjectById(project1.getId(), user2),
                        "Exception should be thrown since not author"),

                () -> verify(projectRepo, times(1)).fetchById(any()),
                () -> verifyNoMoreInteractions(projectRepo),
                () -> verifyZeroInteractions(commentRepo)
        );
    }


    @SuppressWarnings("ConstantConditions")
    @Test
    void postComment_giveKnownProjectId_thenSaveComment() {
        given(commentRepo.existsById(any())).willReturn(false);
        given(projectRepo.findById(project1.getId())).willReturn(Optional.of(project1));
        given(commentRepo.save(comment1)).willReturn(comment1);

        // To make sure that the postComment method sets the author
        comment1.setAuthor(null);

        Comment result = service.postComment(comment1, project1.getId(), user1);

        assertAll("Posting comment with project ID found",
                () -> assertNotNull(result),
                () -> assertEquals(comment1, result,
                        "Comment and result should equal"),
                () -> verify(commentRepo, times(1)).existsById(comment1.getId()),
                () -> verify(projectRepo, times(1)).findById(project1.getId()),
                () -> verify(commentRepo, times(1)).save(comment1),
                () -> verifyNoMoreInteractions(commentRepo, projectRepo)
        );
    }

    @Test
    void postComment_givenUnknownProjectId_ThenException() {
        given(commentRepo.existsById(any())).willReturn(false);

        assertAll("Posting comment with project ID not found",
                () -> assertThrows(ProjectNotFoundException.class,
                        () -> service.postComment(comment1, 20L, user1),
                        "Exception should be thrown due to no project found from the given id"),

                () -> verify(commentRepo, never()).save(any()),
                () -> verify(commentRepo, times(1)).existsById(1L),
                () -> verify(projectRepo, times(1)).findById(20L),
                () -> verifyNoMoreInteractions(projectRepo, commentRepo)
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void updateComment_sameAuthor_thenUpdate() {
        Long originalId = comment1.getId();
        final String originalCommentBody = comment1.getBody();
        given(commentRepo.fetchById(originalId)).willReturn(Optional.of(comment1));

        Comment newComment = Comment.builder().id(originalId).author(user1).project(project1)
                                    .body("new comment").build();

        Comment updated = service.updateComment(newComment, originalId, project1.getId(), user1);


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
                        () -> service.deleteCommentById(comment1.getId(), user2),
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
                () -> service.deleteCommentById(comment1.getId(), user1),

                () -> verify(commentRepo, times(1)).fetchById(comment1.getId()),
                () -> verify(commentRepo, times(1)).delete(comment1),
                () -> verifyNoMoreInteractions(commentRepo, projectRepo)
        );
    }

    @Test
    void testFetchAll_invalidDifficulty() {
        assertThrows(InvalidDifficultyException.class,
                () -> service.fetchAll("title", "invalid-diff", null, null)
        );
    }
}