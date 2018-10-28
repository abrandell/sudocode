package org.sudocode.api.user;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Optionals;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.annotation.ModifyingTX;
import org.sudocode.api.core.exceptions.UserNotFoundException;

import static com.google.common.base.Preconditions.*;

/**
 * Service for user transactions and logging in via OAuth2. Read only by default & rolls back for any exception.
 * <p>
 * Be sure to include another transactional annotation with the required params for any modifying transaction.
 *
 * @see OAuth2UserService
 */
@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class
)
public class UserService {

    private final UserRepository userRepo;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Save a {@link User}
     *
     * @return The newly persisted {@link User}
     */
    @ModifyingTX
    public User saveUser(@NonNull User user) {
        logger.info("Saving user to database {}", user);
        return userRepo.save(user);
    }

    @ModifyingTX
    public User updateUser(User user) {
        checkNotNull(user);

        return userRepo.findById(user.getId())
                       .map(updated -> {
                           updated.setLogin(user.getLogin());
                           updated.setAvatarUrl(user.getAvatarUrl());
                           updated.setHireable(user.isHireable());
                           return updated;
                       })
                       .orElseGet(() -> saveUser(user));
    }

    /**
     * Fetch all users as {@link UserView} projections in a page.
     *
     * @param pageable {@link Pageable}
     * @return Page of all Users in {@link UserView} projections.
     * @see Pageable
     * @see UserView
     */
    public Page<UserView> fetchAllProjections(Pageable pageable) {
        return userRepo.fetchAllUserViews(pageable);
    }

    /**
     * Fetch user by id.
     *
     * @param id of the user to fetch.
     * @return {@link UserView} projection of the {@link User} with the given ID as their PK.
     * @throws UserNotFoundException if the id does not match any persisted user.
     */
    public UserView fetchProjectionById(Long id) {
        return userRepo.findViewById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Fetch user by login.
     *
     * @param login of the user to fetch.
     * @return {@link UserView} projection of the User with the given login.
     * @throws UserNotFoundException if the login does not match any persisted user.
     */
    public UserView fetchProjectionByLogin(String login) {
        return userRepo.fetchUserViewByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Delete a user by id.
     *
     * @param id builder the user to delete.
     */
    @ModifyingTX
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }


}