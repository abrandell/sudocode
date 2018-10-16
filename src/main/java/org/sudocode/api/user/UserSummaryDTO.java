package org.sudocode.api.user;

import lombok.Value;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Value object for a user summary. Used primarily for things like user lists.
 */
@Value
public class UserSummaryDTO {

    private Long id;
    private String login;
    private String avatarUrl;

}
