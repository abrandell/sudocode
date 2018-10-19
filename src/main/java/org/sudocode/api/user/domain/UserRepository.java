package org.sudocode.api.user.domain;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.user.web.UserDTO;

import java.util.Optional;

/**
 * Repository for users. Read only and rolls back for ANY exception.
 *
 * The transaction MUST take place before calling a method here (preferably by {@link org.sudocode.api.user.UserService}
 */
@Repository
@Transactional(
        readOnly = true,
        propagation = Propagation.MANDATORY,
        rollbackFor = Exception.class
)
public interface UserRepository extends JpaRepository<User, Long> {

    static String USER_DTO_PATH = "org.sudocode.api.user.web.UserDTO";

    @Deprecated
    @Query("SELECT NEW " +
                USER_DTO_PATH +
                "(u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM User u")
    Page<UserDTO> fetchAllDTO(Pageable pageable);

    Optional<User> findByLogin(String login);

    @Deprecated
    @Query("SELECT NEW " +
                USER_DTO_PATH +
                "(u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM User u " +
            "WHERE u.login = :login")
    Optional<UserDTO> fetchDTOByLogin(@Param("login") String login);

    @Deprecated
    @Query("SELECT NEW " +
                USER_DTO_PATH +
                "(u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM User u " +
            "WHERE u.id = :id")
    Optional<UserDTO> fetchDTOById(@Param("id") Long id);
}
