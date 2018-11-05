package org.sudocode.api.core;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.sudocode.api.core.security.SecurityUtils;
import org.sudocode.api.user.User;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

	/**
	 * AuditorAware bean that returns the current user.
	 * @return Optional of the currently authenticated user.
	 * @see SecurityUtils#getCurrentUser()
	 * @see AuditorAware
	 */
	@Bean
	public AuditorAware<User> auditorAware() {
		return () -> Optional.of(SecurityUtils.getCurrentUser());
	}
}
