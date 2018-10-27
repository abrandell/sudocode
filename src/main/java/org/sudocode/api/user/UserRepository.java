package org.sudocode.api.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserView;

import java.util.Optional;

/**
 * Repository for users. Read only and rolls back for ANY exception.
 *
 * The transaction MUST take place before calling a method here (preferably by {@link org.sudocode.api.user.UserService}
 */
@Repository
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class,
        propagation = Propagation.MANDATORY
)
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query("select u.id as id, u.login as login, u.avatarUrl as avatarUrl, u.hireable as hireable from User u where u.id = :id")
    Optional<UserView> fetchById(@Param("id") Long id);

}
