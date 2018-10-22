package org.sudocode.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.sudocode.api.core.OAuth2LoginUtils;
import org.sudocode.api.user.domain.User;

import java.util.Map;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2LoginUtils oauth2LoginUtils;

    @Autowired
    public SecurityConfig(OAuth2LoginUtils oauth2LoginUtils) {
        this.oauth2LoginUtils = oauth2LoginUtils;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
           .antMatchers(OPTIONS, "/**")
           .antMatchers("/*.{html, js}");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*.requiresChannel()
                    .requestMatchers(request -> request.getHeader("X-Fowarded-Proto") != null)
                    .requiresSecure()
                    .and()*/
                .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                .authorizeRequests()
                    .antMatchers(GET, "/").permitAll()
                    .antMatchers(GET, "/api/projects/**").permitAll()
                    .antMatchers(GET, "/api/users/me").permitAll()
                    .antMatchers(GET, "/api/users*").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .oauth2Login()
                    .loginPage("/")
                    .successHandler(oauth2LoginUtils.successHandler())
                    .userInfoEndpoint()
                    .customUserType(User.class, "github")
                    .userService(oAuth2UserService());
    }

    private CustomUserTypesOAuth2UserService oAuth2UserService() {
        return new CustomUserTypesOAuth2UserService(Map.of("github", User.class));
    }

}
