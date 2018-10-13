package org.sudocode.api.project;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Long id) {
        super("Comment with id: " + id + " not found");
    }
}
