package org.sudocode.api.post.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.sudocode.api.post.UserPost;
import org.sudocode.api.post.comment.support.CommentBuilder;
import org.sudocode.api.post.project.Project;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
@ToString(callSuper = true)
public class Comment extends UserPost {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Project project;

    @Length(min = 3, max = 500)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent;

    public static CommentBuilder.Builder builder() {
        return new CommentBuilder.Builder();
    }

}