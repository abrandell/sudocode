package org.sudocode.api.post.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.sudocode.api.post.UserPost;
import org.sudocode.api.post.project.support.ProjectBuilder;
import org.sudocode.api.user.User;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Project extends UserPost {

    @Length(min = 5, max = 300)
    private String title;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Size(min = 8, max = 10000)
    @Basic(fetch = FetchType.LAZY)
    private String description;

    @Basic
    private int rating;

    public static ProjectBuilder.Builder builder(@NonNull User author) {
        return new ProjectBuilder.Builder(author);
    }



}
