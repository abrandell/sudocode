package org.sudocode.api.project.web;

import lombok.Data;
import org.sudocode.api.project.domain.Difficulty;

@Data
public class ProjectPost {

    private String title;
    private Difficulty difficulty;
    private String description;

}
