package org.sudocode.api.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;

@Component
public class OAuth2LoginUtils {

    private final UserService userService;

    @Autowired
    public OAuth2LoginUtils(UserService userService) {
        this.userService = userService;
    }

    /**
     * Saves or updates the user that successfully logged in.
     * Redirects back to the origin of the where the user logged in.
     * Useful for dev purposes such as when writing the front end on a different port.
     */
    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            userService.saveUser((User) authentication.getPrincipal());

            // Referrer is intentionally misspelled
            String origin = request.getHeader("Referer");
            new DefaultRedirectStrategy().sendRedirect(request, response, origin);
        };

    }
}
