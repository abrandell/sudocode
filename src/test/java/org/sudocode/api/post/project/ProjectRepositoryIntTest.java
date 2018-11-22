package org.sudocode.api.post.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.security.AuthFacade;
import org.sudocode.api.user.User;
import org.sudocode.api.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.sudocode.api.post.project.Difficulty.ADVANCED;
import static org.sudocode.api.post.project.Difficulty.BEGINNER;

/**
 * {@link ProjectRepository} integration test.
 *
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions">JUnit 5 guide</a>
 */
@DataJpaTest(showSql = true)
@Transactional
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class ProjectRepositoryIntTest {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private UserRepository userRepo;

    @MockBean
    private AuthFacade authFacade;

    private User user1;
    private User user2;

    private Project project1;
    private Project project2;

    @BeforeEach
    void setUp() {
        this.user1 = userRepo.save(
            User.builder()
                .id(1L)
                .login("octocat")
                .avatarUrl("octo-avi")
                .hireable(false)
                .build()
        );

        this.user2 = userRepo.save(
            User.builder()
                .id(2L)
                .login("porzingis")
                .avatarUrl("porz-avi")
                .hireable(false)
                .build()
        );

        this.project1 = Project.builder(user1)
                               .title("Github")
                               .description("Build a site for devs to host their git repos")
                               .difficulty(ADVANCED)
                               .build();

        this.project2 = Project.builder(user2)
                               .title("Tic-Tac-Toe")
                               .description("Build a tic tac toe game.")
                               .difficulty(BEGINNER)
                               .build();

        project1.setDatePosted(LocalDateTime.now());
        project2.setDatePosted(LocalDateTime.now());

        this.project1 = projectRepo.save(project1);
        this.project2 = projectRepo.save(project2);

        given(authFacade.currentUser()).willReturn(user1);
    }

    @Test
    void filterAll_BeginnerDifficulty() {

        Page<ProjectView> result = projectRepo.filterAll(null, BEGINNER, null, null);

        assertAll("FilterAll",
            () -> {
                assertNotNull(result, "Page result must not be null");

                final List<ProjectView> resultList = result.getContent();

                System.out.println(resultList);
                assertAll("ProjectView results",
                    () -> assertEquals(1, resultList.size(),
                        "List should have 1 entry. Make sure project1 difficulty isn't set to BEGINNER"),
                    () -> assertEquals(resultList.get(0).getDescription(), project2.getDescription(),
                        "Description should match for project2 and the first result in the list.")
                );
            });
    }

    @Test
    void lastPostDateByUserId() {
        assertTrue(projectRepo.lastPostDateByUserId(2L).isPresent());
    }

    @Test
    void fetchById() {
        Optional<Project> optionalProject1 = projectRepo.fetchById(project1.getId());

        assertAll("fetchById",
            () -> {
                assertTrue(optionalProject1.isPresent(), "Project should be present");

                final Project result = optionalProject1.get();
                assertEquals(project1, result, "Project1 and result be equal.");
            });
    }

    @Test
    void findViewById() {
        Optional<ProjectView> optionalProjectView = projectRepo.fetchViewById(project1.getId());

        assertAll("findViewById",
            () -> {
                assertTrue(optionalProjectView.isPresent(), "Optional should be present");
                final ProjectView result = optionalProjectView.get();

                assertEquals(project1.getId(), result.getId(), "ID's should be equal");
            });
    }
}