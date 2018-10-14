package org.sudocode.api.project.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.domain.User;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Project project;

    @Length(min = 3, max = 255)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User author;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("project", project)
                .append("body", body)
                .append("author", author)
                .append("datePosted", datePosted)
                .append("lastModifiedDate", lastModifiedDate)
                .toString();
    }
}