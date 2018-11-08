package org.sudocode.api.post.comment;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.sudocode.api.user.UserView;

/**
 * Projection for {@link Comment} entities.
 */
@SuppressWarnings({ "unused" })
@JsonPropertyOrder({
    "id",
    "body",
    "author",
    "last_modified_date",
    "date_posted"
})
public interface CommentView {

    Long getId();

    String getBody();

    UserView getAuthor();

    LocalDateTime getDatePosted();

    LocalDateTime getLastModifiedDate();
}

