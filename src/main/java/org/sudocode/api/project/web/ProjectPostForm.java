package org.sudocode.api.project.web;

import lombok.Value;
import org.sudocode.api.project.domain.Difficulty;

/**
 * Simple value object for posting projects.
 */
@Value
public class ProjectPostForm {

    String title;
    Difficulty difficulty;
    String description;

}
