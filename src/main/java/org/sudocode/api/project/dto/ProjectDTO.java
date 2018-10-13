package org.sudocode.api.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.dto.UserDTO;

import java.time.LocalDateTime;

public class ProjectDTO {

    private final String datePattern = "yyyy-MM-d HH:mm:ss";

    private Long id;
    private String title;
    private Difficulty difficulty;
    private String description;
    private UserDTO author;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
