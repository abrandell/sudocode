package org.sudocode.api.core.security.timeout;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import org.sudocode.api.core.security.SecurityUtils;
import org.sudocode.api.user.User;

@Configuration
public class TimeOutServiceConfig {

	private final TimeOutService timeOutService;

	public TimeOutServiceConfig(TimeOutService timeOutService) {
		this.timeOutService = timeOutService;
	}

	@Bean
	@Order(Ordered.LOWEST_PRECEDENCE)
	public FilterRegistrationBean<OncePerRequestFilter> handleTimeOutFilter() {
		return new FilterRegistrationBean<>(timeoutFilter());
	}

	public OncePerRequestFilter timeoutFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			                                FilterChain filterChain) throws ServletException, IOException {

				if (!request.getRequestURI().contains("vote") && request.getRemoteUser() != null) {

					final String methodRequest = request.getMethod();
					if (methodRequest.matches("(?i)(post|put)")) {

						User user = SecurityUtils.getCurrentUser();
						timeOutService.handleTimeOut(user.getId());
					}
				}
				filterChain.doFilter(request, response);
			}
		};
	}
}