package org.sudocode.api.project.web;

import lombok.Data;
import lombok.Value;

/**
 * Simple value object for posting comments.
 */
@Value
public class CommentForm {

    public String body;
}
