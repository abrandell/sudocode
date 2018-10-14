package org.sudocode.api.project.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.user.UserSummary;

import java.time.LocalDateTime;

@Getter
public class ProjectSummary {

    private final Long id;
    private final String title;
    private final Difficulty difficulty;
    private final String description;
    private final LocalDateTime datePosted;
    private UserSummary author;

    public ProjectSummary(Long id, String title, Difficulty difficulty, String description, LocalDateTime datePosted,
                          Long userId, String login, String avatarUrl) {
        this.id = id;
        this.title = title;
        this.difficulty = difficulty;
        this.description = description;
        this.datePosted = datePosted;
        this.author = new UserSummary(userId, login, avatarUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProjectSummary that = (ProjectSummary) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(title, that.title)
                .append(difficulty, that.difficulty)
                .append(description, that.description)
                .append(datePosted, that.datePosted)
                .append(author, that.author)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(difficulty)
                .append(description)
                .append(datePosted)
                .append(author)
                .toHashCode();
    }
}
