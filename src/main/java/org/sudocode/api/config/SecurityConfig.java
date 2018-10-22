package org.sudocode.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.DelegatingOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.sudocode.api.user.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
                .formLogin()
                    .disable()
                .httpBasic()
                    .disable()
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
                    .userInfoEndpoint()
                    .customUserType(User.class, "github")
                    .userService(oAuth2UserService());
    }

    private CustomUserTypesOAuth2UserService oAuth2UserService() {
        return new CustomUserTypesOAuth2UserService(Map.of("github", User.class));
    }

}
