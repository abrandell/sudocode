package testingutils;

import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.project.Project;
import org.sudocode.api.user.User;

public class ViewMapper {

    public static UserViewMock userToView(User user) {
        return UserViewMock.builder()
                           .id(user.getId())
                           .login(user.getLogin())
                           .hireable(user.isHireable())
                           .avatarUrl(user.getAvatarUrl())
                           .build();
    }

    public static ProjectViewMock projectToView(Project project) {
        return ProjectViewMock.builder()
                              .id(project.getId())
                              .author(userToView(project.getAuthor()))
                              .lastModifiedDate(project.getLastModifiedDate())
                              .datePosted(project.getDatePosted())
                              .difficulty(project.getDifficulty())
                              .description(project.getDescription())
                              .rating(project.getRating())
                              .title(project.getTitle())
                              .build();
    }

    public static CommentViewMock commentToView(Comment comment) {
        return CommentViewMock.builder()
                              .id(comment.getId())
                              .author(userToView(comment.getAuthor()))
                              .body(comment.getBody())
                              .datePosted(comment.getDatePosted())
                              .lastModifiedDate(comment.getLastModifiedDate())
                              .build();
    }
}
