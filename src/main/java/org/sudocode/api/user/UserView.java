package org.sudocode.api.user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Projection for {@link User} entities.
 */
@SuppressWarnings({ "unused" })
@JsonPropertyOrder({ "id", "login", "avatar_url", "hireable" })
public interface UserView {

    Long getId();

    String getLogin();

    String getAvatarUrl();

    boolean isHireable();

}
