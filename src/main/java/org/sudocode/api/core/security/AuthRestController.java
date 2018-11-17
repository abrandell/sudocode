package org.sudocode.api.core.security;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sudocode.api.core.annotation.GetJSON;
import org.sudocode.api.core.annotation.PostJSON;
import org.sudocode.api.user.User;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    /**
     * POST /api/auth/logout
     *
     * Log out. Invalidates the session.
     *
     * @param request the {@link HttpServletRequest} of the user making the call.
     */
    @PostJSON(path = "/logout")
    public void logout(HttpServletRequest request) {
        if (request.isRequestedSessionIdValid()) {
            request.getSession(false).invalidate();
        }
    }

    /**
     * GET /api/auth/user
     *
     * <p>Used for the client to check if a user is logged in. Returns an
     * empty body if not authenticated and no exception gets thrown.
     *
     * @return Currently logged in user.
     */
    @GetJSON(path = "/user")
    public ResponseEntity<?> currentUser(@Nullable Authentication auth) {
        if (auth == null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok((User) auth.getPrincipal());
    }
}
