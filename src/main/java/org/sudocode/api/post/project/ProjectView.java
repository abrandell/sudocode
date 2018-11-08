package org.sudocode.api.post.project;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.sudocode.api.user.UserView;

/**
 * Projection for {@link org.sudocode.api.post.project.Project} entities.
 */
@SuppressWarnings({ "unused" })
@JsonPropertyOrder({
    "id",
    "title",
    "difficulty",
    "description",
    "date_posted",
    "author"
})
public interface ProjectView {

    Long getId();

    String getTitle();

    int getRating();

    Difficulty getDifficulty();

    String getDescription();

    LocalDateTime getDatePosted();

    LocalDateTime getLastModifiedDate();

    UserView getAuthor();
}
