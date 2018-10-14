package org.sudocode.api.project.comment;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudocode.api.user.dto.UserDTO;

import java.time.LocalDateTime;

@Getter
@Setter
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

    /**
     * Constructor with a ridiculous amount of params for JPQL constructor expressions.
     *
     * @see CommentRepository
     */
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
