package testingutils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sudocode.api.user.UserView;

@Data
@AllArgsConstructor
@Builder
public class UserViewMock implements UserView {

	Long id;

	String login;

	String avatarUrl;

	boolean hireable;

}
