package org.sudocode.api.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractEntity {

    @Column(name = "posted_date")
    @CreationTimestamp
    private LocalDateTime datePosted;

    @Column(name = "last_modified")
    private LocalDateTime lastModifiedDate;

    @PreUpdate
    protected void createLastModifiedDate() {
        LocalDateTime currentTime = now();
        this.lastModifiedDate = (this.datePosted != currentTime) ? currentTime : null;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
