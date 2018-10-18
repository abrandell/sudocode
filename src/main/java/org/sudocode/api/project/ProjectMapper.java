package org.sudocode.api.project;

import org.springframework.stereotype.Component;
import org.sudocode.api.project.domain.Project;

@Component
public class ProjectMapper {

    public static ProjectDTO projectToDTO(Project project) {
        return new ProjectDTO(project);
    }
}
