package org.sudocode.api.project.exceptions;

public class InvalidDifficultyException extends RuntimeException {

    InvalidDifficultyException(String text) {
        super(" '" + text + "' is not a Difficulty enum value. " +
                "Difficulties: 'basic, beginner, intermediate, advanced, expert'");
        super.getCause();
    }
}
