package org.sudocode.api.post.project;

import com.fasterxml.jackson.annotation.JsonValue;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;

import java.util.Arrays;

/**
 * Difficulty for the {@link Project} idea.
 *
 * @see Project
 */
public enum Difficulty {

    BASIC("basic"),
    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced"),
    EXPERT("expert");

    private final String difficulty;

    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static Difficulty fromText(String text) {
        return Arrays.stream(values())
                     .filter(diff -> diff.difficulty.equalsIgnoreCase(text))
                     .findFirst()
                     .orElseThrow(() -> new InvalidDifficultyException(text));
    }

    @JsonValue
    @Override
    public String toString() {
        return difficulty;
    }
}
