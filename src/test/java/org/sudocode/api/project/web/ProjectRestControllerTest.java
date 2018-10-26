package org.sudocode.api.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.sudocode.api.project.Project;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.user.User;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserMapper;
import testingutils.WithMockOAuth2User;

import java.io.IOException;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.sudocode.api.project.Difficulty.EXPERT;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(value = ProjectRestController.class, secure = false)
@EnableSpringDataWebSupport
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class ProjectRestControllerTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @MockBean private ProjectService projectService;
    @MockBean private ProjectMapper projectMapper;
    @MockBean private CommentMapper commentMapper;
    @MockBean private UserMapper userMapper;

    private JacksonTester<ProjectDTO> jsonProjectDTO;
    private JacksonTester<Project> jsonProject;
    private JacksonTester<Page<ProjectSummaryDTO>> jsonSummaryPage;
    private JacksonTester<ProjectSummaryDTO> jsonSummaryDTO;
    private JacksonTester<Page<CommentDTO>> jsonCommentDTOPage;
    private JacksonTester<CommentDTO> jsonCommentDTO;
    private JacksonTester<Comment> jsonComment;

    private User user;
    private UserDTO userDTO;
    private Project project;
    private ProjectDTO projectDTO;
    private ProjectSummaryDTO projectSummaryDTO;
    private Page<ProjectSummaryDTO> projectSummaryDTOPage;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, objectMapper);

        this.projectSummaryDTO = new ProjectSummaryDTO(
                1L, "title", EXPERT, "mock-description", now(), 5L, "mock-username", "fake-avatar-url"
        );
        user = User.builder().id(1L).login("mockLogin").build();
        userDTO = new UserDTO(user);
        project = Project.builder(user).id(1L).title("mockTitle").build();
        projectDTO = new ProjectDTO(project);

        List<ProjectSummaryDTO> dtoList = List.of(projectSummaryDTO);
        projectSummaryDTOPage = new PageImpl<>(List.of(projectSummaryDTO), PageRequest.of(0, 20), dtoList.size());


        given(projectService.fetchById(project.getId())).willReturn(project);
        given(projectMapper.toDTO(project)).willReturn(projectDTO);
    }


    @Test
    void fetchAll() throws Exception {
        String expectedJsonResponse = jsonSummaryPage.write(projectSummaryDTOPage).getJson();

        given(projectService.fetchAll(any(), any(), any(), any())).willReturn(projectSummaryDTOPage);

        mockMvc.perform(get("/api/projects"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
               .andExpect(content().json(expectedJsonResponse))
               .andDo(print());

    }

    @Test
    void fetchById() throws Exception {
        String expectedJsonResponse = jsonProjectDTO.write(projectDTO).getJson();

        mockMvc.perform(get("/api/projects/1")
                .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json(expectedJsonResponse))
               .andDo(print());

    }

    @Test
    void postProject() throws Exception {
        User user = User.builder().id(1L).build();
        Project project = Project.builder(user).build();
        ProjectDTO projectDTO = new ProjectDTO(project);

        given(projectService.postProject(any(Project.class))).willReturn(project);
        given(projectMapper.toDTO(project)).willReturn(projectDTO);

        String jsonSubmission = jsonProject.write(project).getJson();

        mockMvc.perform(post("/api/projects")
                .content(jsonSubmission)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(status().isOk())
               .andExpect(content().json(jsonProjectDTO.write(projectDTO).getJson()));
    }

    @Test
    void fetchComments() throws Exception {
        Comment comment = new Comment(1L, project, "Hello", user, null);
        List<Comment> commentList = List.of(comment);
        PageImpl<Comment> commentPage = new PageImpl<>(commentList, PageRequest.of(0, 20), commentList.size());
        Page<CommentDTO> commentDTOPage = commentPage.map(CommentDTO::new);

        given(commentMapper.toDTO(comment)).willReturn(new CommentDTO(comment));
        given(projectService.fetchCommentsByProjectId(any(), any(Pageable.class))).willReturn(commentPage);

        String expectedResponse = jsonCommentDTOPage.write(commentDTOPage).getJson();

        mockMvc.perform(get("/api/projects/1/comments"))
               .andExpect(status().isOk()).andExpect(content().json(expectedResponse)).andDo(print());
    }

    @Test

    void postComment() throws Exception {
        Comment comment = new Comment(1L, project, "I'm posting a comment", user, null);
        CommentDTO commentDTO = new CommentDTO(comment);

        given(projectService.postComment(any(Comment.class), any(Long.class), any(User.class))).willReturn(comment);
        given(commentMapper.toDTO(comment)).willReturn(commentDTO);

        String commentJson = jsonComment.write(comment).getJson();

        mockMvc.perform(post("/api/projects/1/comments")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(commentJson))
               .andExpect(status().isOk())
               .andExpect(content().json(jsonCommentDTO.write(commentDTO).getJson()));

    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteCommentById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}