package org.sudocode.api.project;

import org.sudocode.api.project.domain.Project;

public class ProjectMapper {

    public static ProjectDTO projectToDTO(Project project) {
        return new ProjectDTO(project);
    }

    public static Project dtoToProject(ProjectDTO dto) {
        // FIXME
        return null;
    }
}
