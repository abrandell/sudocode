package org.sudocode.api.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Persistable;
import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends AbstractEntity implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Length(min = 5, max = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Length(min = 8, max = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    private User author;

    @Column(name = "posted_date")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-d HH:mm:ss")
    private LocalDateTime datePosted;

    @Column(name = "last_modified")
    @JsonFormat(pattern = "yyyy-MM-d HH:mm:ss")
    private LocalDateTime lastModifiedDate;

    @PreUpdate
    protected void createLastModifiedDate() {
        LocalDateTime currentTime = now();
        this.lastModifiedDate = (this.datePosted != currentTime) ? currentTime : null;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("title", title)
                .append("difficulty", difficulty)
                .append("description", description)
                .append("author", author)
                .append("datePosted", datePosted)
                .append("lastModifiedDate", lastModifiedDate)
                .toString();
    }
}
