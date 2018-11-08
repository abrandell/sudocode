package org.sudocode.api.core.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.sudocode.api.core.exception.UserNotLoggedInException;
import org.sudocode.api.user.User;

import java.security.Principal;

/**
 * General security convenience methods.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class SecurityUtils {

    /**
     * @return The {@link Principal} in the form builder a {@link User}
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
