package org.sudocode.api.core.exception;

public class NotPostAuthorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotPostAuthorException(String msg) {
        super(msg);
    }
}
