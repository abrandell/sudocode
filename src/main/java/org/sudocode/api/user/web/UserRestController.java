package org.sudocode.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sudocode.api.user.dto.UserDTO;
import org.sudocode.api.user.UserServiceImpl;

import static org.springframework.http.MediaType.*;

/**
 * Rest controller for {@link org.sudocode.api.user.domain.User}.
 */
@RestController
@RequestMapping("api/users")
public final class UserRestController {

    private final UserServiceImpl userService;

    @Autowired
    UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * GET /api/users/me
     * @see UserServiceImpl#currentUserDTO()
     */
    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public UserDTO currentUser() {
        return userService.currentUserDTO();
    }

    /**
     * GET /api/users/:id
     * @see UserServiceImpl#fetchByIdDTO(Long)
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserDTO fetchById(@PathVariable("id") Long id) {
        return userService.fetchByIdDTO(id);
    }

    /**
     * GET /api/users?{page, sort}
     * @see UserServiceImpl#fetchAll(Pageable)
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<UserDTO> fetchAll(Pageable pageable) {
        return userService.fetchAll(pageable);
    }


}
