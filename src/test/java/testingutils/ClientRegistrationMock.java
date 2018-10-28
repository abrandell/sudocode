package testingutils;


import org.springframework.context.annotation.Scope;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

public class ClientRegistrationMock {

    public static ClientRegistration.Builder clientRegistration() {
        return ClientRegistration.withRegistrationId("registration-id")
                                      .redirectUriTemplate("redirect-template")
                                      .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                                      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                                      .scope("read:user")
                                      .authorizationUri("localhost/login/oauth/authorize")
                                      .tokenUri("localhost/login/oauth/access_token")
                                      .jwkSetUri("localhost/oauth2/jwk")
                                      .userInfoUri("https://api.github.com/users/octocat")
                                      .userNameAttributeName("id")
                                      .clientName("client-mock")
                                      .clientId("client-id")
                                      .clientSecret("client-secret");
    }
}
