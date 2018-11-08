package org.sudocode.api.post.comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import org.sudocode.api.post.UserPost;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.user.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
@Accessors(chain = true)
public class Comment extends UserPost {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Project project;

    @Length(min = 3, max = 500)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent;

    private Comment(Builder builder) {
        super.setId(builder.id);
        this.project = builder.project;
        this.body = builder.body;
        super.setAuthor(builder.author);
        this.parent = builder.parent;
    }

    // --- BUILDER --- //

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("project", project)
            .append("body", body)
            .append("author", super.getAuthor())
            .append("parent", parent)
            .toString();
    }

    public static class Builder {
        private Long id;
        private Project project;
        private String body;
        private User author;
        private Comment parent;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder body(String body) {
            Assert.hasText(body, "Body must not be blank or null");
            this.body = body;
            return this;
        }

        public Builder project(@NonNull Project project) {
            this.project = project;
            return this;
        }

        public Builder author(@NonNull User user) {
            this.author = user;
            return this;
        }

        public Builder parentComment(@Nullable Comment parent) {
            this.parent = parent;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }
}