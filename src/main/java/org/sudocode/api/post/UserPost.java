package org.sudocode.api.post;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Base class for all entities which can be posted by a user.
 *
 * @see AbstractEntity
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class UserPost extends AbstractEntity implements Persistable<Long> {

    // So the generator picks IDENTITY instead of TABLE
    // https://vladmihalcea.com/9-high-performance-tips-when-using-mysql-with-jpa-and-hibernate/#more-7915
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "posted_date", updatable = false)
    @CreatedDate
    private LocalDateTime datePosted;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User author;

    @LastModifiedDate
    @Column(name = "last_modified")
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public boolean isPostedBy(User other) {
        return this.author.equals(other);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("datePosted", datePosted)
            .append("author", author)
            .append("lastModifiedDate", lastModifiedDate)
            .toString();
    }

}
