package org.sudocode.api.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Repository for users. Read only and rolls back for ANY exception.
 *
 * The transaction MUST take place before calling a method here (preferably by {@link org.sudocode.api.user.UserService}
 */
@Repository
@Transactional(
        rollbackFor = Exception.class,
        propagation = Propagation.MANDATORY
)
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    /**
     * Query for fetching a {@link UserView} by id.
     * @param id THe ID of the user to retrieve.
     * @return {@link UserView} projection of the user found.
     */
    @Query("SELECT " +
            "u.id AS id, " +
            "u.login AS login, " +
            "u.avatarUrl AS avatarUrl, " +
            "u.hireable AS hireable " +
            "FROM User u WHERE u.id = :id")
    Optional<UserView> fetchUserViewById(@Param("id") Long id);

    /**
     * Query for {@link UserView} projections.
     * Names must match the property names in {@link UserView}
     *
     * @return Page of {@link UserView} projections.
     */
    @Query("SELECT " +
            "u.id AS id, " +
            "u.login AS login, " +
            "u.avatarUrl AS avatarUrl, " +
            "u.hireable AS hireable " +
            "FROM User u")
    Page<UserView> fetchAllUserViews(Pageable pageable);

    @Query("SELECT " +
            "u.id AS id, " +
            "u.login AS login, " +
            "u.avatarUrl AS avatarUrl, " +
            "u.hireable AS hireable " +
            "FROM User u WHERE u.login = :login")
    Optional<UserView> fetchUserViewByLogin(@Param("login") String login);

    Optional<UserView> findViewById(@Param("id") Long id);

}
