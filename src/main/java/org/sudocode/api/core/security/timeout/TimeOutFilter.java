package org.sudocode.api.core.security.timeout;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.sudocode.api.core.security.SecurityUtils;
import org.sudocode.api.post.UserPost;
import org.sudocode.api.user.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class TimeOutFilter extends OncePerRequestFilter {

    private final TimeOutService timeOutService;

    public TimeOutFilter(TimeOutService postingService) {
        this.timeOutService = postingService;
    }

    /**
     * Filter to check if a user is spamming when they post or update any
     * {@link UserPost}.
     *
     * @see TimeOutService#handleTimeOut(Long)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (!request.getRequestURI().contains("vote")
                && request.getRemoteUser() != null) {
            final String methodRequest = request.getMethod();

            if (methodRequest.matches("(?i)(post|put)")) {
                User user = SecurityUtils.getCurrentUser();
                timeOutService.handleTimeOut(user.getId());
            }
        }
        filterChain.doFilter(request, response);
    }

}
