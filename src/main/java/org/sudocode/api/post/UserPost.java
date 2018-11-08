package org.sudocode.api.post;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.core.security.SecurityUtils;
import org.sudocode.api.user.User;

/**
 * Abstract class for all entities which can be posted by a user.
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

}
