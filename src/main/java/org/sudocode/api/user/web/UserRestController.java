package org.sudocode.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sudocode.api.core.annotation.Delete;
import org.sudocode.api.core.annotation.Get;
import org.sudocode.api.core.annotation.Post;
import org.sudocode.api.core.exception.UserNotFoundException;
import org.sudocode.api.user.User;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.UserView;

import javax.servlet.http.HttpServletRequest;

/**
 * Rest controller for {@link User}.
 */
@RestController
@RequestMapping("api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/users/me
     *
     * <p>Used for the client to check if a user is logged in. Returns an
     * empty body if not authenticated and no exception gets thrown.
     *
     * @return Currently logged in user.
     */
    @Get(path = "/me")
    public ResponseEntity<?> currentUser(@Nullable Authentication auth) {
        if (auth == null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok((User) auth.getPrincipal());
    }

    /**
     * GET /api/users/:id
     * <p>
     * Returns the user with the given ID in DTO form.
     *
     * @see UserService#fetchProjectionById(Long)
     */
    @Get(value = "/{id:[\\d]+}")
    public UserView fetchById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.fetchProjectionById(id);
    }

    /**
     * GET /api/users/:login
     * <p>
     * Fetch a {@link UserView} projection by their login.
     *
     * @param login login to search for.
     * @return User with the given login in DTO form.
     */
    @Get(path = "/{login:[A-Za-z]+}")
    public UserView fetchByLogin(@PathVariable String login) {
        return userService.fetchProjectionByLogin(login.toLowerCase());
    }

    /**
     * GET /api/users?{page, sort}
     *
     * @see UserService#fetchAllProjections(Pageable)
     */
    @Get
    public Page<UserView> fetchAll(Pageable pageable) {
        return userService.fetchAllProjections(pageable);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Delete(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @Post(path = "/logout")
    public void logout(HttpServletRequest request) {
        request.getSession(false).invalidate();
    }

}
