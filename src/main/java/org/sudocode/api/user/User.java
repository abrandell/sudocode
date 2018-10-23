package org.sudocode.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.AccessType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import java.util.*;

import static org.springframework.data.annotation.AccessType.*;
import static org.sudocode.api.core.util.Constants.*;

@Entity
@Table(name = "users")
@AccessType(Type.FIELD)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements OAuth2User {

    /**
     * Not generated.
     *
     * Uses the same ID as the github API.
     */
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String login;

    @Column(nullable = false)
    @Pattern(regexp = URL_REGEX)
    private String avatarUrl;

    @Column(nullable = false)
    private boolean hireable;

    /**
     * Required for principal. Returns ID since that never changes (unless Github decides to change it).
     */
    public String getName() {
        return id.toString();
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Only uses the ID since everything else can change.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(id, user.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("id", id)
                .append("login", login)
                .append("avatarUrl", avatarUrl)
                .append("hireable", hireable)
                .toString();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    /**
     * Required to implement {@link OAuth2User}. Do not use.
     *
     * All needed info is provided via standard getters.
     * @return null
     */
    @Deprecated
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }


    // --- BUILDER --- //

    public static Builder builder() {
        return new Builder();
    }

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
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.hireable = builder.hireable;
        this.avatarUrl = builder.avatarUrl;
    }
}