package org.sudocode.api.project.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.project.Project;
import org.sudocode.api.user.web.UserDTO;

import java.time.LocalDateTime;

@Getter
public class CommentDTO {

    private final Long id;
    private final String body;
    private final UserDTO author;
    private final LocalDateTime datePosted;
    private final LocalDateTime lastModifiedDate;

    private Project project;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.body = comment.getBody();
        this.datePosted = comment.getDatePosted();
        this.lastModifiedDate = comment.getLastModifiedDate();
        this.author = new UserDTO(comment.getAuthor());
        this.project = comment.getProject();
    }

    /**
     * Constructor with a ridiculous amount builder params for JPQL constructor expressions.
     *
     * @see CommentRepository
     */
    @Deprecated
    public CommentDTO(Long id, String body, LocalDateTime datePosted,
                      LocalDateTime lastModifiedDate, Long userId,
                      String login, String avatarUrl, boolean hireable) {
        this.id = id;
        this.body = body;
        this.datePosted = datePosted;
        this.lastModifiedDate = lastModifiedDate;
        this.author = new UserDTO(userId, login, avatarUrl, hireable);
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
