package org.sudocode.api.core;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import static org.springframework.http.HttpHeaders.*;

@Component
public class OAuth2ServiceUtils {

    private final OAuth2AuthorizedClientService clientService;

    public OAuth2ServiceUtils(OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

    public OAuth2AuthorizedClient getAuthorizedClient() {
        var token = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return clientService.loadAuthorizedClient(
                token.getAuthorizedClientRegistrationId(),
                token.getName()
        );
    }

    public String getUserInfoUri() {
        return getAuthorizedClient()
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUri();
    }

    /**
     * RestTemplate with the added header "Authorization: Bearer {@literal <access-token>}" if the current auth is OAuth2.
     *
     * @return RestTemplate with the added header.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().interceptors((ClientHttpRequestInterceptor)
                (request, body, execution) -> {

                    var authentication = SecurityContextHolder.getContext().getAuthentication();

                    if (authentication instanceof OAuth2AuthenticationToken) {

                        var token = (OAuth2AuthenticationToken) authentication;

                        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
                                token.getAuthorizedClientRegistrationId(),
                                token.getName()
                        );

                        final String accessToken = client.getAccessToken().getTokenValue();

                        request.getHeaders().add(AUTHORIZATION, "Bearer " + accessToken);
                    }

                    return execution.execute(request, body);
                }).build();
    }
}
