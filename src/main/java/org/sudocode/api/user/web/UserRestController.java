package org.sudocode.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.user.UserService;

import static org.springframework.http.MediaType.*;

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
     * @see UserService#currentUserDTO()
     */
    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public UserDTO currentUser() {
        return mapper.toDTO(userService.currentUser());
    }

    /**
     * GET /api/users/:id
     * @see UserService#fetchByIdDTO(Long)
     */
    @GetMapping(value = "/{id:[\\d]+}", produces = APPLICATION_JSON_VALUE)
    public UserDTO fetchById(@PathVariable("id") Long id) {
        return mapper.toDTO(userService.fetchById(id));
    }

    @GetMapping(value = "/{login:[A-Za-z]+}")
    public UserDTO fetchByLogin(@PathVariable String login) {
        return mapper.toDTO(userService.fetchByLogin(login.toLowerCase()));
    }

    /**
     * GET /api/users?{page, sort}
     * @see UserService#fetchAll(Pageable)
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<UserDTO> fetchAll(Pageable pageable) {
        return userService.fetchAll(pageable).map(mapper::toDTO);
    }

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


}
