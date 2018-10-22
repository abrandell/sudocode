package org.sudocode.api.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.SecurityUtils;
import org.sudocode.api.user.domain.User;
import org.sudocode.api.user.domain.UserRepository;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserSummaryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Service for user transactions. Read only by default & rolls back for any exception.
 * <p>
 * Be sure to include another transactional annotation with the required params for any modifying transaction.
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
    UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    public User saveUser(@NonNull User user) {
        logger.info("Saving user to database {}", user);
        return userRepo.save(user);
    }

    /**
     * Fetch a pageable builder all users in DTO form.
     *
     * @param pageable {@link Pageable}
     * @return Page builder all UserDTOs.
     * @see Pageable
     * @see UserDTO
     */
    public Page<User> fetchAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    /**
     * Fetch user by id.
     *
     * @param id builder the user to fetch.
     * @return User with the given ID as their PK.
     * @throws UserNotFoundException if the id does not match any persisted user.
     */
    public User fetchById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Fetch user by login.
     *
     * @param login builder the user to fetch.
     * @return User with the given login.
     * @throws UserNotFoundException if the login does not match any persisted user.
     */
    public User fetchByLogin(String login) {
        return userRepo.findByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Delete a user by id.
     *
     * @param id builder the user to delete.
     */
    @PreAuthorize("#id.equals(principal.id) || hasRole('ROLE_ADMIN')")
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }


}
