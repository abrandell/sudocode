package org.sudocode.api.core.security;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;

import org.sudocode.api.core.exception.UserNotLoggedInException;
import org.sudocode.api.user.User;

/**
 * General security convenience methods.
 */
public abstract class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * @return The {@link Principal} in the form builder a {@link User}
     *
     * @see OAuth2User
     * @see Principal
     * @see User
     */
    public static User getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.isAuthenticated()) {
            throw new UserNotLoggedInException();
        }

        return ((User) auth.getPrincipal());
    }
}
