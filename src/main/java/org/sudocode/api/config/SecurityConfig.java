package org.sudocode.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.sudocode.api.user.User;
import org.sudocode.api.user.UserService;

import java.util.Map;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
           .antMatchers("/*.{html, js}");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .requiresChannel()
                    .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                    .requiresSecure()
                    .and()
                .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                .authorizeRequests()
                    .antMatchers(POST, "/").authenticated()
                    .antMatchers(PUT).authenticated()
                    .antMatchers(DELETE).authenticated()
                    .antMatchers(PATCH).authenticated()
                    .antMatchers(OPTIONS).denyAll()
                    .antMatchers(TRACE).denyAll()
                    .mvcMatchers("/api/actuator/**/").hasAuthority("ROLE_ADMIN")
                    .anyRequest().permitAll()
                    .and()
                .oauth2Login()
                    .loginPage("/").userInfoEndpoint()
                    .userService(customOAuth2UserService())
                    .and()
                .successHandler(successHandler());
        // @formatter:on
    }

    private CustomUserTypesOAuth2UserService customOAuth2UserService() {
        return new CustomUserTypesOAuth2UserService(Map.of("github", User.class));
    }

    /**
     * Saves or updates the user that successfully logged in. Redirects back to the origin
     * of the where the user logged in. Redirect is useful for developing the front end on
     * a different port.
     */
    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            // Update the user upon login.
            userService.updateUser((User) authentication.getPrincipal());

            if (System.getenv("ACTIVE_PROFILE").equals("dev")) {
                String origin = request.getHeader("Referer");

                // Temp fix.
                // 'Referer' is null if logging into app while already authenticated wit github.
                if (origin == null || origin.isEmpty()) {
                    origin = "http://localhost:4200";
                }
                new DefaultRedirectStrategy().sendRedirect(request, response, origin);
            }
        };
    }
}
