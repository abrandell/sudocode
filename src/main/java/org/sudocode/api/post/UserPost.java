package org.sudocode.api.post;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sudocode.api.core.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

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

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Column(name = "posted_date", updatable = false)
    @CreatedDate
    private LocalDateTime datePosted;

    @LastModifiedDate
    @Column(name = "last_modified")
    private LocalDateTime lastModifiedDate;

}
