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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.sudocode.api.core.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("dev")
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

        Page<User> actual = userService.fetchAll(PageRequest.of(1, 1));

        assertAll("FetchAll",
                () -> actual.getContent().get(0).getId().equals(userMock.getId()));
    }

    @Test
    void fetchById() {
        assertThrows(UserNotFoundException.class, () -> userService.fetchById(99L));
    }

    @Test
    void fetchByLogin() {
        given(userRepoMock.findByLogin("mock-username")).willReturn(Optional.of(userMock));
        assertEquals(userMock, userService.fetchByLogin("mock-username"));
    }

}