package org.sudocode.api.user.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.user.UserNotFoundException;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserMapper;

import static org.springframework.http.MediaType.*;
import static org.sudocode.api.core.util.Constants.JSON;

/**
 * Rest controller for {@link org.sudocode.api.user.domain.User}.
 */
@RestController
@RequestMapping("api/users")
public final class UserRestController {

    private final UserService userService;
    private final UserMapper mapper;

    @Autowired
    UserRestController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    /**
     * GET /api/users/me
     *
     * @return Currently logged in user in DTO form.
     * @see UserService#currentUser()
     */
    @GetMapping(value = "/me", produces = JSON)
    public UserDTO currentUser(@AuthenticationPrincipal User user) {
        return mapper.toDTO(userService.currentUser(user));
    }

    /**
     * GET /api/users/:id
     *
     * Returns the user with the given ID in DTO form.
     *
     * @see UserService#fetchById(Long)
     */
    @GetMapping(value = "/{id:[\\d]+}", produces = JSON)
    public UserDTO fetchById(@PathVariable("id") Long id) throws UserNotFoundException {
        return mapper.toDTO(userService.fetchById(id));
    }

    /**
     *
     * GET /api/users/:login
     *
     * Fetch a user by their login.
     *
     * @param login login to search for.
     * @return User with the given login in DTO form.
     */
    @GetMapping(value = "/{login:[A-Za-z]+}")
    public UserDTO fetchByLogin(@PathVariable String login) {
        return mapper.toDTO(userService.fetchByLogin(login.toLowerCase()));
    }

    /**
     * GET /api/users?{page, sort}
     *
     * @see UserService#fetchAll(Pageable)
     */
    @GetMapping(produces = JSON)
    public Page<UserDTO> fetchAll(Pageable pageable) {
        return userService.fetchAll(pageable).map(mapper::toDTO);
    }

    @DeleteMapping(value = "/{id}", produces = JSON)
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


}
