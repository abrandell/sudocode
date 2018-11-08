package org.sudocode.api.post.project.support;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.sudocode.api.post.project.Difficulty;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.user.User;

public class ProjectBuilder {

    public static class Builder {

        private Long id;
        private String title = "Title-Placeholder";
        private Difficulty difficulty = Difficulty.BASIC;
        private String description = "Description-Placeholder";
        private final User author;

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
            Project project = new Project();
            project.setAuthor(this.author);
            project.setId(this.id);
            project.setTitle(this.title);
            project.setDescription(this.description);
            project.setDifficulty(this.difficulty);
            return project;
        }

    }

}
