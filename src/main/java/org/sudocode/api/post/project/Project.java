package org.sudocode.api.post.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.AccessType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.sudocode.api.post.UserPost;
import org.sudocode.api.post.Vote;
import org.sudocode.api.post.project.support.ProjectBuilder;
import org.sudocode.api.user.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

    private int rating;

    public static ProjectBuilder.Builder builder(@NonNull User author) {
        return new ProjectBuilder.Builder(author);
    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.MERGE)
    private Set<Vote> votes;

/*    @Basic
    @AccessType(AccessType.Type.PROPERTY)
    public int getRating() {
        return votes.stream().mapToInt(value -> value.getDir().primitiveValue()).sum();
    }*/

}
