package org.sudocode.api.user;

public class UserNotLoggedInException extends RuntimeException {

    public UserNotLoggedInException() {
        super("User is not currently logged in");
    }
}
