package org.sudocode.api.core.security.timeout;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.sudocode.api.core.security.timeout.TimeOutService;
import org.sudocode.api.user.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpMethod.*;

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
                if (request.getRemoteUser() != null) {
                    final String methodRequest = request.getMethod();
                    if (methodRequest.equals(POST.toString()) || methodRequest.equals(PUT.toString())) {

                        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                        timeOutService.handleTimeOut(user.getId());
                    }
                }
                filterChain.doFilter(request, response);
            }
        };
    }
}