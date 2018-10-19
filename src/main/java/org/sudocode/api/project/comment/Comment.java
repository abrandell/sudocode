package org.sudocode.api.project.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Preconditions;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.sudocode.api.core.AbstractAuditableEntity;
import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AbstractAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Project project;

    @Length(min = 3, max = 255)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent;

    private Comment(Builder builder) {
        this.id = builder.id;
        this.project = builder.project;
        this.body = builder.body;
        this.author = builder.author;
        this.parent = builder.parent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("project", project)
                .append("body", body)
                .append("author", author)
                .append("datePosted", super.getDatePosted())
                .append("lastModifiedDate", super.getLastModifiedDate())
                .toString();
    }

    // --- BUILDER --- //

    public static Builder builder() {
        return new Builder();
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