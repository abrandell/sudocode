package org.sudocode.api.user;

import lombok.Value;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Value
public class UserSummary {

    private Long id;
    private String login;
    private String avatarUrl;

}
