package testingutils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sudocode.api.post.comment.CommentView;
import org.sudocode.api.user.UserView;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class CommentViewMock implements CommentView {

    Long id;
    String body;
    UserView author;
    LocalDateTime datePosted;
    LocalDateTime lastModifiedDate;

}
