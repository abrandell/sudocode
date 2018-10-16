package org.sudocode.api.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.sudocode.api.user.domain.User;

public interface UserService {

    User currentUser();
    UserDTO currentUserDTO();

    Page<UserDTO> fetchAll(Pageable pageable);

    User fetchById(Long id);
    UserDTO fetchByIdDTO(Long id);

    User fetchByLogin(String login);
    UserDTO fetchByLoginDTO(String login);

    void deleteById(Long id);


}
