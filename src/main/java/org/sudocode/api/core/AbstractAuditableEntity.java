package org.sudocode.api.core;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity extends AbstractEntity {

    @Column(name = "posted_date", updatable = false)
    @CreatedDate
    private LocalDateTime datePosted;

    @Column(name = "last_modified")
    private LocalDateTime lastModifiedDate;

    @PreUpdate
    protected void createLastModifiedDate() {
        LocalDateTime currentTime = now();
        this.lastModifiedDate = (this.datePosted != currentTime) ? currentTime : null;
    }

}
