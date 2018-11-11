package testingutils;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = MockOAuth2SecurityContextFactory.class)
public @interface WithMockOAuth2User {

    String name() default "oauthUser";

    long id() default 1L;

    boolean hireable() default false;

    String[] authorities() default "ROLE_USER";

}
