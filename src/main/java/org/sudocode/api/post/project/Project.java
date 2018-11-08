package org.sudocode.api.post.project;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.sudocode.api.post.UserPost;
import org.sudocode.api.post.Vote;
import org.sudocode.api.user.User;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project extends UserPost {

    @Length(min = 5, max = 300)
    private String title;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Size(min = 8, max = 10000)
    @Basic(fetch = FetchType.LAZY)
    private String description;

    @Basic
    private int rating;

    private Project(Builder builder) {
        super.setId(builder.id);
        this.title = builder.title;
        this.difficulty = builder.difficulty;
        this.description = builder.description;
        super.setAuthor(builder.author);
    }

    public static Builder builder(@NonNull User author) {
        return new Builder(author);
    }

    public void vote(Vote vote) {
        this.rating += vote.primitiveValue();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", super.getId())
            .append("title", title)
            .append("difficulty", difficulty)
            .append("description", description)
            .append("author", super.getAuthor())
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
