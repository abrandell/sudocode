package org.sudocode.api.core;

public class TooManyRequestException extends RuntimeException {

    public TooManyRequestException() {
        super("Too many requests made.");
    }
}
