package org.sudocode.api.user;

public class UserNotLoggedInException extends RuntimeException {

    private static final long serialversionUID = 1L;

    public UserNotLoggedInException() {
        super("User is not currently logged in");
    }
}
