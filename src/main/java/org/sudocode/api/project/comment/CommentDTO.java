package org.sudocode.api.project.comment;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.user.dto.UserDTO;

import java.time.LocalDateTime;


public class CommentDTO {

    private Long id;
    private String body;
    private UserDTO author;
    private LocalDateTime datePosted;
    private LocalDateTime lastModifiedDate;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.body = comment.getBody();
        this.datePosted = comment.getDatePosted();
        this.lastModifiedDate = comment.getLastModifiedDate();
        this.author = new UserDTO(comment.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CommentDTO that = (CommentDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(body, that.body)
                .append(author, that.author)
                .append(datePosted, that.datePosted)
                .append(lastModifiedDate, that.lastModifiedDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(body)
                .append(author)
                .append(datePosted)
                .append(lastModifiedDate)
                .toHashCode();
    }
}
