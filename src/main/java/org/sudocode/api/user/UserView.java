package org.sudocode.api.user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.web.ProjectedPayload;
import org.sudocode.api.user.User;


/**
 * Projection for {@link User} entities.
 */
@SuppressWarnings({"unused"})
@JsonPropertyOrder({"id", "login", "avatar_url", "hireable"})
public interface UserView {

    Long getId();
    String getLogin();
    String getAvatarUrl();
    boolean isHireable();

}
