package org.sudocode.api.core;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.sudocode.api.user.UserNotLoggedInException;
import org.sudocode.api.user.domain.User;

import java.security.Principal;

/**
 * General security convenience methods.
 */
public class SecurityUtils {

    /**
     * @return The {@link Principal} in the form builder a {@link User}
     * @see OAuth2User
     * @see Principal
     * @see User
     */
    public static User getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new UserNotLoggedInException();
        }

        return ((User) auth.getPrincipal());

    }
}
