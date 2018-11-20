package org.sudocode.api.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sudocode.api.core.AbstractEntity;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.user.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Vote extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private VoteEnum dir;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;



}
