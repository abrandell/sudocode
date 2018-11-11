package org.sudocode.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.sudocode.api.core.security.AuthFacade;
import org.sudocode.api.user.User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AppConfig {

    private final AuthFacade authFacade;

    public AppConfig(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    /**
     * AuditorAware bean that returns the current user.
     *
     * @return Optional of the currently authenticated user.
     * @see AuthFacade#currentUser()
     * @see AuditorAware
     */
    @Bean
    public AuditorAware<User> auditorAware() {
        return () -> Optional.of(authFacade.currentUser());
    }

}
