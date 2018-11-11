package org.sudocode.api.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import testingutils.UserViewMock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserRepositoryIntTest {

    @Autowired
    UserRepository userRepo;

    private User octocat;
    private User porzingis;

    @BeforeEach
    void setUp() {
        this.octocat = userRepo.save(
            User.builder()
                .id(1L)
                .login("octocat")
                .avatarUrl("octo-avi")
                .hireable(false)
                .build()
        );

        this.porzingis = userRepo.save(
            User.builder()
                .id(2L)
                .login("porzingis")
                .avatarUrl("porz-avi")
                .hireable(false)
                .build()
        );
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Test
    void fetchUserViewById() {

        Optional<UserView> octoCatViewOpt = userRepo.fetchUserViewById(octocat.getId());

        assertAll("Projection view -- fetchByID",
            () -> assertTrue(octoCatViewOpt.isPresent(),
                "Optional should be non-empty"),
            () -> assertEquals(octoCatViewOpt.get().getId(), octocat.getId(),
                "ID's should match"),
            () -> assertEquals(octoCatViewOpt.get().getLogin(), octocat.getLogin(),
                "Login should match"),
            () -> assertEquals(octoCatViewOpt.get().getAvatarUrl(), octocat.getAvatarUrl(),
                "Avatar URL's should match"),
            () -> assertEquals(octoCatViewOpt.get().isHireable(), octocat.isHireable(),
                "Hireable should match")
        );
    }

    @Test
    void fetchUserViewById_notFound() {
        assertFalse(userRepo.fetchUserViewById(-1L).isPresent());
    }

    @Test
    void fetchAllUserViews() {
        Page<UserView> userViewPage =
            userRepo.fetchAllUserViews(PageRequest.of(0, 20, Sort.Direction.ASC, "id"));

        List<UserView> userViews = userViewPage.getContent();

        assertAll("FetchAll -- UserView page",
            () -> assertEquals(2, userViews.size(),
                "Size should be two. Check to make sure only two users were saved"),
            () -> assertEquals(porzingis.getLogin(), userViews.get(1).getLogin(),
                "Login should match")
        );
    }
}