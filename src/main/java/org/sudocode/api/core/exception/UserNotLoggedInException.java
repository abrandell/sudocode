package org.sudocode.api.core.exception;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;

/**
 * Thrown for when a request to get the current user {@link OAuth2User} fails due to not
 * being logged in.
 *
 * @see AuthenticatedPrincipal
 * @see OAuth2User
 * @see Authentication
 */
public class UserNotLoggedInException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotLoggedInException() {
        super("User is not currently logged in");
    }

}
