package org.sudocode.api.user.web;

import com.google.common.base.Preconditions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.sudocode.api.user.domain.User;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserSummaryDTO;

import static com.google.common.base.Preconditions.*;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        checkNotNull(user);
        return new UserDTO(user);
    }

    public User fromEntity(UserDTO dto) {
        checkNotNull(dto);

        return User.builder()
                   .id(dto.getId())
                   .avatarUrl(dto.getAvatarUrl())
                   .login(dto.getLogin())
                   .hireable(dto.isHireable())
                   .build();
    }

    public UserSummaryDTO toSummaryDTO(User user) {
        return UserSummaryDTO.builder()
                             .id(user.getId())
                             .login(user.getLogin())
                             .avatarUrl(user.getAvatarUrl())
                             .build();
    }
}
