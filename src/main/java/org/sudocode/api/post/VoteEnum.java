package org.sudocode.api.post;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VoteEnum {

    UPVOTE(1),
    DOWNVOTE(-1);

    private final int value;

    VoteEnum(int value) {
        this.value = value;
    }

    /**
     * The primitive int value of the vote.
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
