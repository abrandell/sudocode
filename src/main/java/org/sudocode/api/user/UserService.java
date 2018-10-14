package org.sudocode.api.user;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.sudocode.api.core.OAuth2ServiceUtils;
import org.sudocode.api.core.SecurityUtils;
import org.sudocode.api.user.domain.User;
import org.sudocode.api.user.domain.UserRepository;
import org.sudocode.api.user.dto.UserDTO;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static com.google.common.base.Preconditions.*;
import static com.google.common.util.concurrent.RateLimiter.*;

@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class)
public class UserService {

    private static final String GITHUB_USER_ENDPOINT = "https://api.github.com/user";

    private final OAuth2ServiceUtils oauth2Utils;
    private final RestTemplate restTemplate;
    private final UserRepository userRepo;
    private final static RateLimiter rateLimiter = RateLimiter.create(1.0);

    @Autowired
    UserService(OAuth2ServiceUtils oauth2Utils, RestTemplate restTemplate, UserRepository userRepo) {
        this.oauth2Utils = oauth2Utils;
        this.restTemplate = restTemplate;
        this.userRepo = userRepo;
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
     * @param pageable
     * @return Page of all UserDTOs.
     * @see Pageable
     * @see UserDTO
     */
    public Page<UserDTO> fetchAll(Pageable pageable) {
        var users = userRepo.fetchAll(pageable);

        System.out.println(" -----------------------------" + LocalDateTime.now());
        return users;
    }

    /**
     * Fetch user by id.
     *
     * @param id of the user to fetch.
     * @return User with the given ID as their PK.
     * @throws UserNotFoundException if the id does not match any persisted user.
     */
    public User fetchById(Long id) {
        rateLimiter.acquire(1);
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
        rateLimiter.acquire(1);
        return userRepo.findByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Delete a user by id.
     *
     * @param id of the user to delete.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        rateLimiter.acquire(1);
        userRepo.deleteById(id);
    }

    /**
     * Fetch by login in DTO form.
     *
     * @see UserService#fetchByLogin(String)
     */
    public UserDTO fetchByLoginDTO(String login) {
        rateLimiter.acquire(1);
        return userRepo.fetchDTOByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Current user in DTO form.
     *
     * @see UserService#currentUser()
     */
    public UserDTO currentUserDTO() {
        rateLimiter.acquire(1);
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

    private User getUserFromRestCall(String url) {
        rateLimiter.acquire(1);
        User user = restTemplate.getForObject(url, User.class);
        checkNotNull(user);
        return user;
    }

}
