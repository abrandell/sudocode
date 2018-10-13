package org.sudocode.api.project;

public class ProjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 19101L;

    /**
     * Exception thrown when the given ID doesn't match any entity's ID in the database.
     * @param id - the ID given.
     */
    public ProjectNotFoundException(Long id) {
        super("No project with the id " + id + " exists.");
        super.getCause();
    }
}
