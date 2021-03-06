package org.sudocode.api.core.exception;

import org.sudocode.api.post.project.Project;

/**
 * Thrown when a {@link Project} couldn't be found in the DB.
 */
public class ProjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Exception thrown when the given ID doesn't match any entity's ID in the database.
     *
     * @param id - the ID given.
     */
    public ProjectNotFoundException(Long id) {
        super("No project with the id " + id + " exists.");
    }

}
