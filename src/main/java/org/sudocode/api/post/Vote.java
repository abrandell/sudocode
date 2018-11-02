package org.sudocode.api.post;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.builder.ToStringBuilder;

public enum Vote {

    UPVOTE(1),
    UNVOTE(0),
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
