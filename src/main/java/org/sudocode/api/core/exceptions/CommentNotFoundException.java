package org.sudocode.api.core.exceptions;

/**
 * Exception for when a {@link org.sudocode.api.post.comment.Comment} could not be found in the DB.
 */
public class CommentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommentNotFoundException(Long id) {
        super("Comment with id: " + id + " not found");
    }
}
