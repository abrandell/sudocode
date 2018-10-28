package org.sudocode.api.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.sudocode.api.core.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

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

    private User userMock;

    @BeforeEach
    void setUp() {
        this.userMock = User.builder().id(1L).login("kporzee6").build();
        this.userService = new UserService(userRepoMock);

    }

    @Test
    void saveUser() {
        given(userRepoMock.save(userMock)).willReturn(userMock);
        var result = userService.saveUser(userMock);

        assertEquals(result, userMock);
    }

    @Test
    void fetchAll() {
        given(userRepoMock.findAll(any(Pageable.class))).willReturn(new PageImpl<>(List.of(userMock)));

//        Page<User> actual = userService.filterAll(PageRequest.of(1, 1));
//
//        assertAll("FetchAll",
//                () -> assertEquals(actual.getContent().get(0).getId(), userMock.getId()));
    }

    @Test
    void fetchById() {
        assertThrows(UserNotFoundException.class, () -> userService.fetchProjectionById(-1L));
    }

    @Test
    void fetchByLogin() {
        given(userRepoMock.findByLogin("mock-username")).willReturn(Optional.of(userMock));
        assertEquals(userMock, userService.fetchProjectionByLogin("mock-username"));
    }

}