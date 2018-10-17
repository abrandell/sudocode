package org.sudocode.api.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.AccessType;
import org.springframework.hateoas.Identifiable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.*;

import java.util.Collection;
import java.util.Map;

import static org.springframework.data.annotation.AccessType.*;

@Entity
@Table(name = "users")
@AccessType(Type.FIELD)
@Getter
@Setter
public class User implements OAuth2User {

    /**
     * Not auto-generated.
     *
     * Uses the same ID as the github API.
     */
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String login;

    @Column(nullable = false)
    private String avatarUrl;

    @Column(nullable = false)
    private boolean hireable;

    /**
     * Required for principal. Returns ID since that never changes.
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
        return new ToStringBuilder(this)
                .append("id", id)
                .append("login", login)
                .append("avatarUrl", avatarUrl)
                .append("hireable", hireable)
                .toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    /**
     * Required to implement {@link OAuth2User}. Do not use.
     *
     * All needed info is provided via standard getters.
     * @return null
     */
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    public static class Builder {
        private Long id;
        private String login;
        private String avatarUrl = "https://dummyimage.com/200x200/000/fff";
        private boolean hireable;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public Builder hireable(boolean hireable) {
            this.hireable = hireable;
            return this;
        }

        public User build() {
            User user = new User();

            user.setId(this.id);
            user.setLogin(this.login);
            user.setAvatarUrl(this.avatarUrl);
            user.setHireable(this.hireable);

            return user;
        }
    }
}
