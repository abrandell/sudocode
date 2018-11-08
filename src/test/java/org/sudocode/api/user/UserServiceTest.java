package org.sudocode.api.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.sudocode.api.core.exception.UserNotFoundException;

import testingutils.UserViewMock;

import java.util.List;
import java.util.Optional;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserServiceTest {

    private final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    private UserService userService;

    @MockBean(classes = UserRepository.class)
    private UserRepository userRepoMock;

    private User user1;
    private UserViewMock userViewMock1;

    @BeforeEach
    void setUp() {
        this.user1 = User.builder().id(1L).login("porzingod").build();
        userViewMock1 = UserViewMock.builder().id(1L).login("porzingod").build();
        this.userService = new UserService(userRepoMock);

    }

    @Test
    void saveUser() {
        given(userRepoMock.save(user1)).willReturn(user1);
        var result = userService.saveUser(user1);

        assertEquals(result, user1);
    }

    @Test
    void fetchAll() {
        given(userRepoMock.fetchAllUserViews(any(Pageable.class))).willReturn(new PageImpl<>(List.of(userViewMock1)));

        Page<UserView> actual = userService.fetchAllProjections(PageRequest.of(1, 1));

        assertAll("FetchAll",
                () -> assertEquals(actual.getContent().get(0).getId(), userViewMock1.getId()));
    }

    @Test
    void fetchById() {
        assertThrows(UserNotFoundException.class, () -> userService.fetchProjectionById(-1L));
    }

    @Test
    void fetchByLogin() {
        given(userRepoMock.fetchUserViewByLogin("mock-username")).willReturn(Optional.of(userViewMock1));
        assertEquals(userViewMock1, userService.fetchProjectionByLogin("mock-username"));
    }

}