package org.sudocode.api.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    private final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepoMock;

    private User user1;
    private UserViewMock userViewMock1;

    @BeforeEach
    void setUp() {
        this.user1 = User.builder().id(1L).login("porzingod").build();
        userViewMock1 = UserViewMock.builder().id(1L).login("porzingod").build();

    }

    @Test
    void saveUser() {
        given(userRepoMock.save(user1)).willReturn(user1);
        var result = userService.saveUser(user1);

        assertEquals(result, user1);
    }

    @Test
    void fetchAll() {
        given(userRepoMock.fetchAllUserViews(any(Pageable.class)))
            .willReturn(new PageImpl<>(List.of(userViewMock1)));

        Page<UserView> actual = userService.fetchAllProjections(PageRequest.of(1, 1));

        assertAll("FetchAll",
                () -> assertEquals(actual.getContent().get(0).getId(), userViewMock1.getId())
        );
    }

    @Test
    void fetchById_notFound_thenException() {
        assertThrows(UserNotFoundException.class,
            () -> userService.fetchProjectionById(-1L)
        );
    }

    @Test
    void fetchByLogin() {
        given(userRepoMock.fetchViewByLogin("mock-username")).willReturn(Optional.of(userViewMock1));

        assertEquals(userViewMock1, userService.fetchProjectionByLogin("mock-username"));
    }

    @Test
    void updateUser_notInDB_thenSaveNew() {
        User user = User.builder().id(9L).login("newuser").build();

        given(userRepoMock.findById(user.getId())).willReturn(Optional.empty());
        given(userRepoMock.save(user)).willReturn(user);


        var result = userService.updateUser(user);

        assertAll("Update user -- not in DB -- save new",

                () -> assertEquals(result, user, "User and result should match."),
                () -> verify(userRepoMock, times(1)).findById(user.getId()),
                () -> verify(userRepoMock, times(1)).save(any()),
                () -> verifyNoMoreInteractions(userRepoMock)
        );
    }

    @Test
    void updateUser_inDB_thenUpdate() {
        given(userRepoMock.findById(user1.getId())).willReturn(Optional.of(user1));

        final User og = User.builder().id(user1.getId()).login(user1.getLogin()).build();
        User updated = User.builder().id(user1.getId()).login("new-login").build();
        User result = userService.updateUser(updated);


        assertAll("Update user -- ID in DB -- then update",
                () -> assertNotEquals(og.getLogin(), result.getLogin(), "Logins should not match"),
                () -> assertEquals(updated.getLogin(), result.getLogin(), "Logins should match"),
                () -> assertEquals(user1.getId(), result.getId(), "ID's should match"),

                () -> verify(userRepoMock, times(1)).findById(user1.getId()),
                () -> verifyNoMoreInteractions(userRepoMock)
        );
    }

}