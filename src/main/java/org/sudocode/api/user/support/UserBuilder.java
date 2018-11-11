package org.sudocode.api.user.support;

import org.springframework.util.Assert;
import org.sudocode.api.user.User;

import static org.sudocode.api.core.Constants.URL_REGEX_PATTERN;

/**
 * Fluent builder for User POJO's.
 */
public final class UserBuilder {

    public static class Builder {

        private Long id;
        private String login = "placeholder-name";
        private String avatarUrl = "https://dummyimage.com/200x200/000/fff";
        private boolean hireable;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            Assert.hasText(login, "Login cannot be blank.");
            this.login = login;
            return this;
        }

        /**
         * Optional. Defaults to a placeholder image.
         *
         * @return Builder
         */
        public Builder avatarUrl(String avatarUrl) {
            if (URL_REGEX_PATTERN.matcher(avatarUrl).matches()) {
                this.avatarUrl = avatarUrl;
            }
            return this;
        }

        public Builder hireable(boolean hireable) {
            this.hireable = hireable;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(this.id);
            user.setHireable(this.hireable);
            user.setLogin(this.login);
            user.setAvatarUrl(this.avatarUrl);
            return user;
        }

    }

}
