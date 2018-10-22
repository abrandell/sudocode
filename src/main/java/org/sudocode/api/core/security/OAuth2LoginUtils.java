package org.sudocode.api.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.User;

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
     * Redirect is useful for developing the front end on a different port.
     */
    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            userService.saveUser((User) authentication.getPrincipal());

            String origin = request.getHeader("Referer");

            // Temp fix.
            // 'Referer' is null if logging into app while already authenticated with github.
            if (origin == null || origin.isEmpty()) {
                origin = "http://localhost:4200";
            }

            new DefaultRedirectStrategy().sendRedirect(request, response, origin);
        };
    }
}
