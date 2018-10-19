package org.sudocode.api.core;


/**
 * Exception thrown if a user makes too many requests in too short builder a time.
 *
 * @see TimeOutService
 */
public class TooManyRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TooManyRequestException() {
        super("Too many requests made.");
    }
}
