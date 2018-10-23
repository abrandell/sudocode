package org.sudocode.api.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.sudocode.api.core.security.SecurityUtils;
import org.sudocode.api.user.User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    public AuditorAware<User> auditorAware() {
        return () -> Optional.of(SecurityUtils.getCurrentUser());
    }
}
