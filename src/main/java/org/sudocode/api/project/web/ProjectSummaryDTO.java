package org.sudocode.api.project.web;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.project.Difficulty;
import org.sudocode.api.project.Project;
import org.sudocode.api.user.User;
import org.sudocode.api.user.web.UserSummaryDTO;

import java.time.LocalDateTime;

@Getter
public class ProjectSummaryDTO {

    private Long id;
    private String title;
    private Difficulty difficulty;
    private String description;
    private LocalDateTime datePosted;
    private UserSummaryDTO author;

    public ProjectSummaryDTO(Long id, String title, Difficulty difficulty, String description, LocalDateTime datePosted,
                             Long userId, String login, String avatarUrl) {
        this.id = id;
        this.title = title;
        this.difficulty = difficulty;
        this.description = description;
        this.datePosted = datePosted;
        this.author = UserSummaryDTO.builder()
                                    .id(userId)
                                    .login(login)
                                    .avatarUrl(avatarUrl)
                                    .build();
    }

    public ProjectSummaryDTO(Project project) {
        User author = project.getAuthor();

        this.id = project.getId();
        this.title = project.getTitle();
        this.difficulty = project.getDifficulty();
        this.description = project.getDescription();
        this.author = UserSummaryDTO.builder()
                                    .id(author.getId())
                                    .login(author.getLogin())
                                    .avatarUrl(author.getAvatarUrl())
                                    .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProjectSummaryDTO that = (ProjectSummaryDTO) o;

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
