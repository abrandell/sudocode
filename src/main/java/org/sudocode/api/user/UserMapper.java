package org.sudocode.api.user;

import org.sudocode.api.user.domain.User;

public class UserMapper {

    public static UserDTO userToDTO(User user) {
        return new UserDTO(user);
    }
}
