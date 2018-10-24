package util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.sudocode.api.user.User;

@Component
public class SecurityTestingUtils {

    @Bean
    public User getCurrentMockedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
