package org.sudocode.api.project.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sudocode.api.user.web.UserMapper;

import static com.google.common.base.Preconditions.*;

@Component
public class CommentMapper {

    private final UserMapper userMapper;

    @Autowired
    public CommentMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public CommentDTO toDTO(Comment comment) {
        checkNotNull(comment);
        return new CommentDTO(comment);
    }

    @Deprecated
    public Comment toEntity(CommentDTO dto) {
        return Comment.builder()
                      .id(dto.getId())
                      .author(userMapper.toEntity(dto.getAuthor()))
                      .body(dto.getBody())
                      .project(dto.getProject())
                      .build();
    }
}
