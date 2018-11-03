package org.sudocode.api.post;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VoteEnum {

    UPVOTE(1),
    UNVOTE(0),
    DOWNVOTE(-1);

    int value;

    VoteEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public int primitiveValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
