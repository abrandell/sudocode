package org.sudocode.api.post.project;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.lang.NonNull;

import org.sudocode.api.core.exceptions.InvalidDifficultyException;

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

	private final String stringValue;

	Difficulty(String difficulty) {
		this.stringValue = difficulty;
	}

	/**
	 * Returns the Enum from the text value param.
	 *
	 * @param value - the value (string) of the enum constant to get. Ignores casing.
	 * @return the Enum constant if the text matches any.
	 * @throws InvalidDifficultyException if no enum has the value of the string param.
	 */
	public static Difficulty difficultyEnumFromValue(@NonNull String value) {
		String paramValue = value.trim();

		return Arrays.stream(values())
		             .filter(difficulty -> difficulty.stringValue.equalsIgnoreCase(paramValue))
		             .findFirst()
		             .orElseThrow(() -> new InvalidDifficultyException(paramValue));
	}

	@JsonValue
	@Override
	public String toString() {
		return stringValue;
	}
}
