package org.sudocode.api.post.comment.support;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.user.User;

public class CommentBuilder {

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
            Comment comment = new Comment();
            comment.setId(this.id);
            comment.setProject(this.project);
            comment.setBody(this.body);
            comment.setAuthor(this.author);
            comment.setParent(this.parent);
            return comment;
        }

    }

}
