package testingutils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sudocode.api.post.project.Difficulty;
import org.sudocode.api.post.project.ProjectView;
import org.sudocode.api.user.UserView;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ProjectViewMock implements ProjectView {

    Long id;
    String title;
    Difficulty difficulty;
    String description;
    LocalDateTime datePosted;
    LocalDateTime lastModifiedDate;
    UserView author;

}
