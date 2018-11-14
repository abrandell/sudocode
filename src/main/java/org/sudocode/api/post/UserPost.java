package org.sudocode.api.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Base class for all entities which can be posted by a user.
 * @see AbstractEntity
 */
@MappedSuperclass
@Getter
@Setter
@ToString(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class UserPost extends AbstractEntity implements Persistable<Long> {

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

    public boolean isPostedBy(User other) {
        return this.author.equals(other);
    }

}
