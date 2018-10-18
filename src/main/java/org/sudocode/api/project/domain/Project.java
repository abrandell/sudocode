package org.sudocode.api.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;
import org.sudocode.api.core.AbstractAuditableEntity;
import org.sudocode.api.user.domain.User;

import javax.persistence.*;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends AbstractAuditableEntity implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Length(min = 5, max = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Length(min = 8, max = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    private User author;


    /**
     * If the id is null, it hasn't been persisted to the DB yet.
     * @return false if ID is null, true otherwise.
     */
    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("title", title)
                .append("difficulty", difficulty)
                .append("description", description)
                .append("author", author)
                .append("datePosted", super.getDatePosted())
                .append("lastModifiedDate", super.getLastModifiedDate())
                .toString();
    }

    /**
     * Builder. Mainly for testing purposes.
     */
    public static class Builder {
        private final Long id;
        private final User author;

        private String title = "Title-Placeholder";
        private Difficulty difficulty = Difficulty.BASIC;
        private String description = "Description-Placeholder";

        public Builder(@Nullable Long id, User author) {
            this.id = id;
            this.author = author;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder difficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Project build() {
            Project project = new Project();

            project.setId(id);
            project.setAuthor(author);
            project.setDescription(description);
            project.setTitle(title);
            project.setDifficulty(difficulty);

            return project;
        }

    }

}
