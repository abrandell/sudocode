package org.sudocode.api.core.exception;


/**
 * Exception thrown if a user makes too many requests in too short of a time.
 *
 * @see org.sudocode.api.core.security.timeout.TimeOutService
 */
public class TooManyRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TooManyRequestException() {
        super("Too many requests made.");
    }
}
