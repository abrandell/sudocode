package testingutils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.sudocode.api.user.User;

import static java.time.Instant.now;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;
import static org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;

public class MockOAuth2SecurityContextFactory
    implements WithSecurityContextFactory<WithMockOAuth2User> {

    @Override
    public SecurityContext createSecurityContext(WithMockOAuth2User mockOAuth2User) {

        OAuth2AccessToken accessToken = new OAuth2AccessToken(TokenType.BEARER,
            "mock-token", now().minusSeconds(5), now().plusSeconds(500));

        OAuth2UserRequest request = new OAuth2UserRequest(
            ClientRegistrationMock.clientRegistration().build(), accessToken);

        User user = User.builder().login(mockOAuth2User.name()).id(mockOAuth2User.id())
                        .build();

        Authentication auth = new OAuth2AuthenticationToken(user,
            createAuthorityList(mockOAuth2User.authorities()), "registration-id");

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);
        return context;
    }

}
