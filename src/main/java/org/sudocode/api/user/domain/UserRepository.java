package org.sudocode.api.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.user.UserDTO;

import java.util.Optional;

/**
 * Repository for users. Read only and rolls back for ANY exception.
 *
 * The transaction MUST take place before calling a method here (preferably by {@link org.sudocode.api.user.UserServiceImpl}
 */
@Repository
@Transactional(
        readOnly = true,
        propagation = Propagation.MANDATORY,
        rollbackFor = Exception.class
)
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT NEW " +
                "org.sudocode.api.user.UserDTO" +
                "(u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM User u")
    Page<UserDTO> fetchAll(Pageable pageable);

    Optional<User> findByLogin(String login);

    @Query("SELECT NEW " +
                "org.sudocode.api.user.UserDTO" +
                "(u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM User u " +
            "WHERE u.login = :login")
    Optional<UserDTO> fetchDTOByLogin(@Param("login") String login);

    @Query("SELECT NEW " +
                "org.sudocode.api.user.UserDTO" +
                "(u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM User u " +
            "WHERE u.id = :id")
    Optional<UserDTO> fetchDToById(@Param("id") Long id);
}
