package org.sudocode.api.post;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Vote {

    UPVOTE(1),
    DOWNVOTE(-1);

    private final int value;

    Vote(int value) {
        this.value = value;
    }

    /**
     * The primitive int value of the Vote enum.
     *
     * @return the primitive value (-1 or 1).
     */
    @JsonValue
    public int primitiveValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
