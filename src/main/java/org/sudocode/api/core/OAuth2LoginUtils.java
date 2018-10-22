package org.sudocode.api.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.sudocode.api.user.UserService;
import org.sudocode.api.user.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

            String origin = request.getHeader("Referer");

            // Quick hack until I figure out why Referer is null when logging in while not authenticated with github already
            if (origin == null || origin.isEmpty()) {
                origin = "http://localhost:4200";
            }

            new DefaultRedirectStrategy().sendRedirect(request, response, origin);
        };

    }

}
