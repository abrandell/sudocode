package org.sudocode.api.project.web;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.sudocode.api.project.Difficulty;
import org.sudocode.api.user.web.UserView;

import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "title", "difficulty", "description", "date_posted", "author"})
public interface ProjectView {

    Long getId();
    String getTitle();
    Difficulty getDifficulty();
    String getDescription();
    LocalDateTime getDatePosted();
    UserView getAuthor();
}
