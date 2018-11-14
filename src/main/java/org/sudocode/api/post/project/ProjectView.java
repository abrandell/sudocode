package org.sudocode.api.post.project;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.sudocode.api.user.UserView;

import java.time.LocalDateTime;

/**
 * Projection for {@link org.sudocode.api.post.project.Project} entities.
 */
@SuppressWarnings({"unused"})
@JsonPropertyOrder({
        "id",
        "title",
        "difficulty",
        "rating",
        "description",
        "date_posted",
        "last_modified",
        "author"
})
public interface ProjectView {

    Long getId();

    String getTitle();

    UserView getAuthor();

    Difficulty getDifficulty();

    int getRating();

    String getDescription();

    LocalDateTime getDatePosted();

    LocalDateTime getLastModifiedDate();
}
