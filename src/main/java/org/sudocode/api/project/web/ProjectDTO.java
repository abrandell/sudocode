package org.sudocode.api.project.web;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.web.UserDTO;

import java.time.LocalDateTime;

@Getter
public class ProjectDTO {

    private final Long id;
    private final String title;
    private final Difficulty difficulty;
    private final String description;
    private final UserDTO author;

    private LocalDateTime datePosted;

    private LocalDateTime lastModifiedDate;


    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.difficulty = project.getDifficulty();
        this.description = project.getDescription();
        this.datePosted = project.getDatePosted();
        this.lastModifiedDate = project.getLastModifiedDate();
        this.author = new UserDTO(project.getAuthor());
    }

    /**
     * Constructor with a ridiculous amount builder params for JPQL constructor expressions.
     *
     * Not to be used directly.
     *
     * @see org.sudocode.api.project.domain.ProjectRepository
     */
    public ProjectDTO(Long id, String title, Difficulty difficulty, String description,
                      LocalDateTime datePosted, LocalDateTime lastModifiedDate,
                      Long userId, String login, String avatarUrl, boolean hireable) {
        this.id = id;
        this.title = title;
        this.difficulty = difficulty;
        this.datePosted = datePosted;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
        this.author = new UserDTO(userId, login, avatarUrl, hireable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProjectDTO that = (ProjectDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(title, that.title)
                .append(difficulty, that.difficulty)
                .append(description, that.description)
                .append(author, that.author)
                .append(datePosted, that.datePosted)
                .append(lastModifiedDate, that.lastModifiedDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(difficulty)
                .append(description)
                .append(author)
                .append(datePosted)
                .toHashCode();
    }
}
