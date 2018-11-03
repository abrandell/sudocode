package org.sudocode.api.post;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Vote {

    UPVOTE(1),
    DOWNVOTE(-1);

    int value;

    Vote(int value) {
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
