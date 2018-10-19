package org.sudocode.api.user.web;

import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Value object for a user summary. Used primarily for things like user lists.
 */
@Value
@Builder
public class UserSummaryDTO {

    private Long id;
    private String login;
    private String avatarUrl;

}
