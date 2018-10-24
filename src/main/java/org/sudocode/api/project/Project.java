package org.sudocode.api.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.sudocode.api.core.AbstractAuditableEntity;
import org.sudocode.api.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
public class Project extends AbstractAuditableEntity implements Persistable<Long> {

    // So the generator picks IDENTITY instead of TABLE
    // https://vladmihalcea.com/9-high-performance-tips-when-using-mysql-with-jpa-and-hibernate/#more-7915
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

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_fk")
    private User author;

    private Project(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.difficulty = builder.difficulty;
        this.description = builder.description;
        this.author = builder.author;
    }

    public static Builder builder(@NonNull User author) {
        return new Builder(author);
    }

    /**
     * If the id is null, it hasn't been persisted to the DB yet.
     *
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
     * Builder for a more fluid api.
     */
    public static class Builder {
        private final User author;

        private Long id;
        private String title = "Title-Placeholder";
        private Difficulty difficulty = Difficulty.BASIC;
        private String description = "Description-Placeholder";

        public Builder(@NonNull User author) {
            this.author = author;
        }

        public Builder id(@Nullable Long id) {
            this.id = id;
            return this;
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
            return new Project(this);
        }

    }

}
