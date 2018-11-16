package org.sudocode.api.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.Assert;
import org.sudocode.api.core.annotation.ReadOnlyTX;
import org.sudocode.api.core.annotation.TransactionalService;
import org.sudocode.api.core.exception.UserNotFoundException;

import java.util.concurrent.CompletableFuture;

/**
 * Service for user transactions. Read only by default & rolls back for any exception.
 * @see TransactionalService
 */
@TransactionalService
public class UserService {

    private final UserRepository userRepo;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Save a {@link User}
     * @return The newly persisted {@link User}
     */
    User saveUser(User user) {
        logger.debug("Saving user to database {}", user);
        return userRepo.save(user);
    }

    /**
     * Update a user.
     */
    @SuppressWarnings("UnusedReturnValue")
    @Async
    public CompletableFuture<User> updateUser(User user) {
        Assert.notNull(user.getId(), () -> "User ID must not be null!");

        return CompletableFuture
                .completedFuture(
                        userRepo.findById(user.getId())
                                .map(updated -> {
                                    updated.setLogin(user.getLogin());
                                    updated.setAvatarUrl(user.getAvatarUrl());
                                    updated.setHireable(user.isHireable());
                                    logger.info("Updated user with ID: {}", updated.getId());
                                    return updated;
                                }).orElseGet(() -> saveUser(user))
                );
    }

    /**
     * Fetch all users as {@link UserView} projections in a page.
     * @param pageable {@link Pageable}
     * @return Page of all Users in {@link UserView} projections.
     * @see Pageable
     * @see UserView
     */
    @ReadOnlyTX
    public Page<UserView> fetchAllProjections(Pageable pageable) {
        return userRepo.fetchAllUserViews(pageable);
    }

    /**
     * Fetch user by id.
     * @param id of the user to fetch.
     * @return {@link UserView} projection of the {@link User} with the given ID as their
     * PK.
     * @throws UserNotFoundException if the id does not match any persisted user.
     */
    @ReadOnlyTX
    public UserView fetchProjectionById(Long id) {
        return userRepo.findViewById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Fetch user by login.
     * @param login of the user to fetch.
     * @return {@link UserView} projection of the User with the given login.
     * @throws UserNotFoundException if the login does not match any persisted user.
     */
    @ReadOnlyTX
    public UserView fetchProjectionByLogin(String login) {
        return userRepo.fetchViewByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Delete a user by id.
     * @param id of the user to delete.
     */
    public void deleteById(Long id) {
        logger.debug("Deleting user with id: {}", id);
        userRepo.deleteById(id);
    }

}
