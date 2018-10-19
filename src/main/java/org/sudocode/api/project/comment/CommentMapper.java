package org.sudocode.api.project.comment;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.*;

@Component
public class CommentMapper {

    public CommentDTO toDTO(Comment comment) {
        checkNotNull(comment);
        return new CommentDTO(comment);
    }
}
