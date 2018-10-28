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
        "description",
        "date_posted",
        "author"
})
public interface ProjectView {

    Long getId();

    String getTitle();

    Difficulty getDifficulty();

    String getDescription();

    LocalDateTime getDatePosted();

    UserView getAuthor();
}
