package org.sudocode.api.core;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.sudocode.api.user.domain.User;

import java.security.Principal;
import java.util.Optional;

public class SecurityUtils {

    /**
     * @return The {@link Principal} in the form of a {@link User}
     * @see OAuth2User
     * @see Principal
     * @see User
     */
    public static Optional<User> getCurrentUser() {
        return Optional.of((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
