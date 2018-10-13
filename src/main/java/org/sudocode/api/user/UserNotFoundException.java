package org.sudocode.api.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User with id: " + id + " not found");
        super.getCause();
    }

    public UserNotFoundException(String login) {
        super("User with login: " + login + " not found");
        super.getCause();
    }
}
