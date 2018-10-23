package org.sudocode.api.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.sudocode.api.user.User;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    @Override
    public OAuth2User loadUser(@NonNull OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        logger.debug("------ token expires in {}", userRequest.getAccessToken().getExpiresAt());

        if (userRequest.getAccessToken() == null || userRequest.getAccessToken().getTokenValue().isEmpty()) {
            throw new OAuth2AuthenticationException(
                    new OAuth2Error("access_token_null_or_empty"), "Missing required Access Token"
            );
        }

        final String accessToken = userRequest.getAccessToken().getTokenValue();

        RestTemplate restTemplate = new RestTemplateBuilder().interceptors(
                (ClientHttpRequestInterceptor) (request, body, execution) -> {
                    request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
                    return execution.execute(request, body);
                }).build();

        final String userInfoEndpoint = userRequest.getClientRegistration().
                getProviderDetails().getUserInfoEndpoint().getUri();

        User user = restTemplate.getForObject(userInfoEndpoint, User.class);

        return user;

    }
}
