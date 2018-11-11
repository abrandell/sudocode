package org.sudocode.api.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.AccessType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.sudocode.api.user.support.UserBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.*;
import static org.springframework.data.annotation.AccessType.Type;
import static org.sudocode.api.core.Constants.URL_REGEX;

@Entity
@Table(name = "users")
@AccessType(Type.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class User implements OAuth2User, Serializable {

    @JsonIgnore
    @Transient
    private static long serialVersionUID = 1L;

    /**
     * Not generated.
     * <p>
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
     * @return Fluent builder for creating a {@link User} POJO.
     * @see UserBuilder
     */
    public static UserBuilder.Builder builder() {
        return new UserBuilder.Builder();
    }

    /**
     * Required for principal. Returns ID since that never changes (unless Github decides
     * to change it).
     */
    @JsonIgnore
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
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        User user = (User) o;
        return new EqualsBuilder().append(id, user.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id).toHashCode();
    }

    @JsonIgnore
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    /**
     * Required to implement {@link OAuth2User}. All needed info is provided via standard
     * getters.
     *
     * @return null
     */
    @Deprecated
    @Override
    @Nullable
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SIMPLE_STYLE)
            .append("id", id)
            .append("login", login)
            .append("avatarUrl", avatarUrl)
            .append("hireable", hireable).toString();
    }

}
