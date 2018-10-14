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
import org.sudocode.api.core.AbstractAuditableEntity;
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
public class Project extends AbstractAuditableEntity implements Persistable<Long> {

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
                .append("datePosted", super.getDatePosted())
                .append("lastModifiedDate", super.getLastModifiedDate())
                .toString();
    }
}
