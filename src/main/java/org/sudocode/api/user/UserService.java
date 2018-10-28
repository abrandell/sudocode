package org.sudocode.api.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.sudocode.api.core.exceptions.UserNotFoundException;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserView;

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
public class UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

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
    public Page<UserView> fetchAll(Pageable pageable) {
        return userRepo.fetchAllUserViews(pageable);
    }

    /**
     * Fetch user by id.
     *
     * @param id builder the user to fetch.
     * @return User with the given ID as their PK.
     * @throws UserNotFoundException if the id does not match any persisted user.
     */
    public UserView fetchById(Long id) {
        return userRepo.fetchUserViewById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Fetch user by login.
     *
     * @param login builder the user to fetch.
     * @return User with the given login.
     * @throws UserNotFoundException if the login does not match any persisted user.
     */
    public UserView fetchByLogin(String login) {
        return userRepo.fetchUserViewByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
    }

    /**
     * Delete a user by id.
     *
     * @param id builder the user to delete.
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }


    /**
     * Fetches the {@link OAuth2User} from the Github UserInfoEndpoint using their access token.
     *
     * <pre>
     * Adds the header {@literal "Bearer: Authorization: <access-token>"} to the http GET request.
     * Searches for the ueser in the database by id and no record exists, returns the newly persisted {@link User}
     * </pre>
     *
     * @return The newly logged in user.
     * @throws OAuth2AuthenticationException if the access token is null.
     * @see OAuth2UserService
     * @see OAuth2UserRequest
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        if (userRequest.getAccessToken() == null) {
            throw new OAuth2AuthenticationException(
                    new OAuth2Error("access_token_null"), "Missing required OAuth2AccessToken"
            );
        }

        final OAuth2AccessToken accessToken = userRequest.getAccessToken();

        logger.debug("AccessToken issued at {} and expires in {}", accessToken.getIssuedAt(),
                accessToken.getExpiresAt());

        final String accessTokenValue = userRequest.getAccessToken().getTokenValue();

        RestTemplate template = new RestTemplateBuilder().interceptors(
                (ClientHttpRequestInterceptor) (request, body, execution) -> {
                    request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + accessTokenValue);
                    return execution.execute(request, body);
                }).build();

        final String userInfoEndpoint = userRequest.getClientRegistration().getProviderDetails()
                                                   .getUserInfoEndpoint().getUri();

        final User user = template.getForObject(userInfoEndpoint, User.class);

        Assert.notNull(user, "User cannot be null.");
        return userRepo.findById(user.getId()).orElseGet(() -> saveUser(user));
    }
}