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
public class User implements Identifiable<Long>, OAuth2User {

    /**
     * Not generated.
     *
     * Uses the same ID as the github API.
     */
    @Id
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

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @JsonIgnore
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }
}
