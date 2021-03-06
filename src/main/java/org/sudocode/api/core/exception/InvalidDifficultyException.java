package org.sudocode.api.core.exception;

public class InvalidDifficultyException extends RuntimeException {

    public InvalidDifficultyException(String text) {
        super(" '" + text + "' is not a Difficulty enum value. "
                + "Difficulties: 'basic, beginner, intermediate, advanced, expert'");
        super.getCause();
    }

}
