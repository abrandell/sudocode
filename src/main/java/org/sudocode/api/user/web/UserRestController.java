package org.sudocode.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.core.exceptions.UserNotFoundException;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.User;

import javax.servlet.http.HttpServletRequest;

import static org.sudocode.api.core.util.Constants.JSON;

/**
 * Rest controller for {@link User}.
 */
@RestController
@RequestMapping("api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/users/me
     * Used for the client to check if a user is logged in.
     * Returns an empty body if not authenticated so no exception gets thrown
     *
     * @return Currently logged in user in DTO form.
     */
    @GetMapping(value = "/me", produces = JSON)
    public ResponseEntity<?> currentUser(Authentication auth) {
        if (auth == null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok((User) auth.getPrincipal());
    }

    /**
     * GET /api/users/:id
     *
     * Returns the user with the given ID in DTO form.
     *
     * @see UserService#fetchById(Long)
     */
    @GetMapping(value = "/{id:[\\d]+}", produces = JSON)
    public UserView fetchById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.fetchById(id);
    }

    /**
     *
     * GET /api/users/:login
     *
     * Fetch a {@link UserView} projection by their login.
     *
     * @param login login to search for.
     * @return User with the given login in DTO form.
     */
    @GetMapping(value = "/{login:[A-Za-z]+}", produces = JSON)
    public UserView fetchByLogin(@PathVariable String login) {
        return userService.fetchByLogin(login.toLowerCase());
    }

    /**
     * GET /api/users?{page, sort}
     *
     * @see UserService#fetchAll(Pageable)
     */
    @GetMapping(produces = JSON)
    public Page<UserView> fetchAll(Pageable pageable) {
        return userService.fetchAll(pageable);
    }


    @DeleteMapping(value = "/{id}", produces = JSON)
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PostMapping(value = "/logout")
    public void logout(HttpServletRequest request) {
        request.getSession(false).invalidate();
    }

}
