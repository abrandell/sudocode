package org.sudocode.api.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.sudocode.api.project.Project;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.user.User;
import org.sudocode.api.user.web.UserMapper;

import java.util.List;

import static java.time.LocalDateTime.now;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.sudocode.api.project.Difficulty.EXPERT;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProjectRestController.class, secure = false)
@EnableSpringDataWebSupport
public class ProjectRestControllerTest {

    @Autowired
    PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProjectService projectService;
    @MockBean
    private ProjectMapper projectMapper;
    @MockBean
    private AuditorAware<User> mockAuditorAware;

    @MockBean
    private CommentMapper commentMapper;

    @MockBean
    private UserMapper userMapper;

    private JacksonTester<ProjectDTO> jsonProjectDTO;
    private JacksonTester<Project> jsonProject;
    private JacksonTester<Page<ProjectSummaryDTO>> jsonSummaryPage;
    private JacksonTester<ProjectSummaryDTO> jsonSummaryDTO;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, objectMapper);
    }


    @Test
    void fetchAll() throws Exception {

        ProjectSummaryDTO projectSummaryDTO =
                new ProjectSummaryDTO(1L,
                        "title",
                        EXPERT,
                        "mock-description",
                        now(),
                        5L,
                        "mock-username",
                        "fake-avatar-url"
                );

        List<ProjectSummaryDTO> dtoList = List.of(projectSummaryDTO);
        Page<ProjectSummaryDTO> dtoPage = new PageImpl<>(dtoList, PageRequest.of(0, 20), dtoList.size());

        String expectedJsonResponse = jsonSummaryPage.write(dtoPage).getJson();

        given(projectService.fetchAll(any(), any(), any(), any())).willReturn(dtoPage);

        mockMvc.perform(get("/api/projects"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
               .andExpect(content().json(expectedJsonResponse))
               .andDo(print());

    }

    @Test
    void fetchById() throws Exception {
        User user = User.builder().id(1L).login("mockLogin").build();
        Project project = Project.builder(user).id(1L).title("mockTitle").build();
        ProjectDTO dto = new ProjectDTO(project);

        given(projectService.fetchById(project.getId())).willReturn(project);
        given(projectMapper.toDTO(project)).willReturn(dto);

        String expectedJsonResponse = jsonProjectDTO.write(dto).getJson();

        mockMvc.perform(get("/api/projects/1")
                .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json(expectedJsonResponse))
               .andDo(print());

    }

    @Test
    void fetchComments() {
    }

    @Test
    void postComment() {
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