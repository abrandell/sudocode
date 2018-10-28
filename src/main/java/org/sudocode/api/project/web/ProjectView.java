package org.sudocode.api.project.web;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.criterion.Projection;
import org.sudocode.api.project.Difficulty;
import org.sudocode.api.user.web.UserView;

import java.time.LocalDateTime;

/**
 * Projection for {@link org.sudocode.api.project.Project} entities.
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
