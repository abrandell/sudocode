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
import org.sudocode.api.core.annotation.GetJSON;
import org.sudocode.api.core.annotation.PostJSON;
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
     * GET /api/users/:id
     * <p>
     * Returns the user with the given ID in DTO form.
     *
     * @see UserService#fetchProjectionById(Long)
     */
    @GetJSON(value = "/{id:[\\d]+}")
    public UserView fetchById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.fetchProjectionById(id);
    }

    /**
     * GET /api/users/:login
     * <p>
     * Fetch a {@link UserView} projection by their login.
     *
     * @param login login to search for.
     * @return User with the given login in projection form.
     */
    @GetJSON(path = "/{login:[A-Za-z]+}")
    public UserView fetchByLogin(@PathVariable String login) {
        return userService.fetchProjectionByLogin(login.toLowerCase());
    }

    /**
     * GET /api/users?{page, sort}
     *
     * @see UserService#fetchAllProjections(Pageable)
     */
    @GetJSON
    public Page<UserView> fetchAll(Pageable pageable) {
        return userService.fetchAllProjections(pageable);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || principal.id.equals(#id)")
    @Delete(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


}
