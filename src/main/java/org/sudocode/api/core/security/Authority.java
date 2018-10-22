package org.sudocode.api.core.security;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_authorities")
public class Authority implements GrantedAuthority {

    @Id
    @Column(unique = true, updatable = false)
    private String authority;

    public Authority(UserRole authority) {
        this.authority = authority.toString();
    }

    public Authority() {}

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Authority that = (Authority) o;

        return new EqualsBuilder()
                .append(authority, that.authority)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(authority)
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("authority", authority)
                .toString();
    }
}
