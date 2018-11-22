package org.sudocode.api.core.security.timeout;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.sudocode.api.core.security.AuthFacade;
import org.sudocode.api.post.Post;
import org.sudocode.api.user.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TimeOutFilter extends OncePerRequestFilter {

    private final TimeOutService timeOutService;
    private final AuthFacade authFacade;

    public TimeOutFilter(TimeOutService postingService, AuthFacade authFacade) {
        this.timeOutService = postingService;
        this.authFacade = authFacade;
    }

    /**
     * Filter to check if a user is spamming when they post or update any
     * {@link Post}.
     *
     * @see TimeOutService#handleTimeOut(Long)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        if (!request.getRequestURI().contains("vote")
            && request.getRemoteUser() != null) {
            final String methodRequest = request.getMethod();

            if (methodRequest.matches("(?i)(post|put)")) {
                User current = authFacade.currentUser();
                timeOutService.handleTimeOut(current.getId());
            }
        }
        filterChain.doFilter(request, response);
    }

}
