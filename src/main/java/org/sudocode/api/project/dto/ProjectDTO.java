package org.sudocode.api.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.dto.UserDTO;

import java.time.LocalDateTime;

@Getter
public class ProjectDTO {

    private final String datePattern = "yyyy-MM-d HH:mm:ss";

    private final Long id;
    private final String title;
    private final Difficulty difficulty;
    private final String description;
    private final UserDTO author;

    @JsonFormat(pattern = datePattern)
    private LocalDateTime datePosted;

    @JsonFormat(pattern = datePattern)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProjectDTO that = (ProjectDTO) o;

        return new EqualsBuilder()
                .append(datePattern, that.datePattern)
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
                .append(datePattern)
                .append(id)
                .append(title)
                .append(difficulty)
                .append(description)
                .append(author)
                .append(datePosted)
                .toHashCode();
    }
}
