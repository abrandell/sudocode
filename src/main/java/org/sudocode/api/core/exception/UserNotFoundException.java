package org.sudocode.api.core.exception;

/**
 * Thrown when a user couldn't be found by the given param in the DB.
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(Long id) {
        super("User with id: " + id + " not found");
    }

    public UserNotFoundException(String login) {
        super("User with login: " + login + " not found");
    }

}
