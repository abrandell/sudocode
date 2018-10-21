package org.sudocode.api.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    private final Logger logger = LoggerFactory.getLogger(ProjectServiceTest.class);

    @InjectMocks
    private ProjectService service;

    @Mock private ProjectRepository projectRepo;
    @Mock private CommentRepository commentRepo;

    private User user1;
    private User user2;

    private Project project1;
    private Project project2;

    @BeforeEach
    void setUp() {
        user1 = User.builder().id(1L).build();
        user2 = User.builder().id(2L).build();

        project1 = Project.builder(user1).id(1L).description("project-1 desc")
                          .difficulty(Difficulty.BASIC).title("project1-title").build();

        project2 = Project.builder(user2).id(2L).description("project-2 desc")
                .difficulty(Difficulty.INTERMEDIATE).title("project2-title").build();

    }

    @SuppressWarnings("ConstantConditions")
    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void updateProject_notSameAuthor_ThenNotOverwrite() {
        Long projectId = project1.getId();
        project2.setAuthor(null);

        given(projectRepo.fetchById(projectId)).willReturn(Optional.of(project1));
        given(projectRepo.existsById(projectId)).willReturn(true);
        given(projectRepo.save(project2)).willReturn(project2);


        Project result = service.updateProject(projectId, project2, user2);

        logger.debug(result.toString() + "\n\n" + project1);

        assertAll("Project update",
                () -> assertNotEquals(1L, project1.getId(),
                        "project2 should not replace project1 since different authors" +
                                "\n\n" + result.toString() + "\n\n" + project1),
                () -> verify(projectRepo, times(1)).fetchById(projectId),
                () -> verify(projectRepo, times(1)).save(project2),
                () -> verify(projectRepo, times(1)).existsById(projectId),
                () -> verifyNoMoreInteractions(projectRepo)
        );
    }

}