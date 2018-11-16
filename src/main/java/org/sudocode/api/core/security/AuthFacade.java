package org.sudocode.api.core.security;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.sudocode.api.core.exception.UserNotLoggedInException;
import org.sudocode.api.user.User;

import java.security.Principal;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * Class for general security methods all in one place.
 */
@Component
@Scope(SCOPE_PROTOTYPE)
public class AuthFacade {

    /**
     * @return The {@link Principal} in the form of a {@link User}
     * @see OAuth2User
     * @see Principal
     * @see User
     */
    public User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new UserNotLoggedInException();
        }

        return ((User) auth.getPrincipal());
    }
}
