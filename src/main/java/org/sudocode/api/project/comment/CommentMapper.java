package org.sudocode.api.project.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sudocode.api.project.web.ProjectMapper;
import org.sudocode.api.user.web.UserMapper;

import static com.google.common.base.Preconditions.*;

@Component
public class CommentMapper {

    private final UserMapper userMapper;
    private final ProjectMapper projectMapper;

    @Autowired
    public CommentMapper(UserMapper userMapper, ProjectMapper projectMapper) {
        this.userMapper = userMapper;
        this.projectMapper = projectMapper;
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
