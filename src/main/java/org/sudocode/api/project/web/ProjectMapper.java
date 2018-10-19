package org.sudocode.api.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.user.domain.User;
import org.sudocode.api.user.web.UserMapper;

@Component
public class ProjectMapper {

    private final UserMapper userMapper;

    @Autowired
    public ProjectMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ProjectDTO toDTO(Project project) {
        return new ProjectDTO(project);
    }

    @Deprecated
    public Project toEntity(ProjectDTO dto) {
        User author = userMapper.toEntity(dto.getAuthor());

        return Project.builder(author)
                      .id(dto.getId())
                      .description(dto.getDescription())
                      .difficulty(dto.getDifficulty())
                      .title(dto.getTitle())
                      .build();
    }
}
