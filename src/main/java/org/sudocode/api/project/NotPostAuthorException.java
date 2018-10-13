package org.sudocode.api.project;

public class NotPostAuthorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotPostAuthorException(String msg) {
        super(msg);
        super.getCause();
    }
}
