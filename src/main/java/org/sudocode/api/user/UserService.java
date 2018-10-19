package org.sudocode.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.SecurityUtils;
import org.sudocode.api.user.domain.User;
import org.sudocode.api.user.domain.UserRepository;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserMapper;

/**
 * Service for user transactions. Read only by default & rolls back for any exception.
 *
 * Be sure to include another transactional annotation with the required params for any modifying transaction.
 */
@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class
)
public class UserService {

    private final UserRepository userRepo;
    private final UserMapper mapper;

    @Autowired
    UserService(UserRepository userRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    /**
     * Get the currently logged in user.
     *
     * @return the currently logged in user.
     * @throws UserNotLoggedInException if the {@code Principal} is null.
     */
    @Transactional(rollbackFor = Exception.class)
    public User currentUser() {

        User currentUser = SecurityUtils.getCurrentUser().orElseThrow(UserNotLoggedInException::new);

        if (!userRepo.existsById(currentUser.getId())) {
            return userRepo.save(currentUser);
        }

        return currentUser;
    }

    /**
     * Fetch a pageable of all users in DTO form.
     *
     * @param pageable {@link Pageable}
     * @return Page of all UserDTOs.
     * @see Pageable
     * @see UserDTO
     */
    public Page<User> fetchAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    /**
     * Fetch user by id.
     *
     * @param id of the user to fetch.
     * @return User with the given ID as their PK.
     * @throws UserNotFoundException if the id does not match any persisted user.
     */
    public User fetchById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Fetch user by login.
     *
     * @param login of the user to fetch.
     * @return User with the given login.
     * @throws UserNotFoundException if the login does not match any persisted user.
     */
    public User fetchByLogin(String login) {
        return userRepo.findByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Delete a user by id.
     *
     * @param id of the user to delete.
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    /**
     * Fetch by login in DTO form.
     *
     * @see UserService#fetchByLogin(String)
     */
    public User fetchByLoginDTO(String login) {
        return userRepo.findByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Current user in DTO form.
     *
     * @see UserService#currentUser()
     */
    public UserDTO currentUserDTO() {
        return new UserDTO(currentUser());
    }

    /**
     * Fetch by ID in DTO form.
     *
     * @see UserService#fetchById(Long)
     */
    public UserDTO fetchByIdDTO(Long id) {
        return new UserDTO(fetchById(id));
    }

}
