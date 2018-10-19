package org.sudocode.api.user.web;

import lombok.*;
import org.sudocode.api.user.domain.User;

/**
 * DTO/Value Object for returning serialized User entities.
 */
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String login;
    private String avatarUrl;
    private boolean hireable;

    public UserDTO(@NonNull User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.avatarUrl = user.getAvatarUrl();
        this.hireable = user.isHireable();
    }

    public UserDTO(Long id, String login, String avatarUrl, boolean hireable) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.hireable = hireable;
    }
}
