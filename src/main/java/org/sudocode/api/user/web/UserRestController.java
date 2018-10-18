package org.sudocode.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.user.UserDTO;
import org.sudocode.api.user.UserService;

import static org.springframework.http.MediaType.*;

/**
 * Rest controller for {@link org.sudocode.api.user.domain.User}.
 */
@RestController
@RequestMapping("api/users")
public final class UserRestController {

    private final UserService userService;

    @Autowired
    UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/users/me
     * @see UserService#currentUserDTO()
     */
    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public UserDTO currentUser() {
        return userService.currentUserDTO();
    }

    /**
     * GET /api/users/:id
     * @see UserService#fetchByIdDTO(Long)
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserDTO fetchById(@PathVariable("id") Long id) {
        return userService.fetchByIdDTO(id);
    }

    /**
     * GET /api/users?{page, sort}
     * @see UserService#fetchAll(Pageable)
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<UserDTO> fetchAll(Pageable pageable) {
        return userService.fetchAll(pageable);
    }

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


}
