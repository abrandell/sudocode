package org.sudocode.api.project.dto;

import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.user.UserSummary;

import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getDescription() {
        return description;
    }

    public UserSummary getAuthor() {
        return author;
    }

    public void setAuthor(UserSummary author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectSummary that = (ProjectSummary) o;

        if (!id.equals(that.id)) return false;
        if (!title.equals(that.title)) return false;
        if (difficulty != that.difficulty) return false;
        if (!description.equals(that.description)) return false;
        if (!datePosted.equals(that.datePosted)) return false;
        return author.equals(that.author);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + difficulty.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + datePosted.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
