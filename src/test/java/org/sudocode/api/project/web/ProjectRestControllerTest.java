package org.sudocode.api.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.sudocode.api.ServerApplication;
import org.sudocode.api.core.RestExceptionHandler;
import org.sudocode.api.project.Difficulty;
import org.sudocode.api.project.ProjectRepository;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.user.UserRepository;
import org.sudocode.api.user.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.time.LocalDateTime.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.boot.test.json.JacksonTester.initFields;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
import static org.sudocode.api.project.Difficulty.EXPERT;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ProjectRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @Mock
    private ProjectMapper projectMapper;

    @Mock
    private CommentMapper commentMapper;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectRestController restController;

    @Mock
    private RestExceptionHandler exceptionHandler;

    private JacksonTester<Page<ProjectSummaryDTO>> jsonSummaryPage;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());

        this.mockMvc = MockMvcBuilders.standaloneSetup(restController)
                                      .setControllerAdvice(exceptionHandler)
                                      .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                                      .setViewResolvers((ViewResolver)
                                              (viewName, locale) -> new MappingJackson2JsonView()
                                      ).build();
    }

    @Test
    void post() {
    }

    @Test
    void fetchAll() throws Exception {

        List<ProjectSummaryDTO> dtoList = List.of(
                new ProjectSummaryDTO(
                        1L, "title", EXPERT, "description",
                        now(), 1L, "login", "avatarUrl"
                )
        );
        Page<ProjectSummaryDTO> dtoPage = new PageImpl<>(dtoList);

        given(projectService.fetchAll(any(), any(), any(), any())).willReturn(dtoPage);

        MockHttpServletResponse response = mockMvc.perform(get("/api/projects")).andReturn().getResponse();

        assertAll("GET /api/projects",
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertNotNull(response.getContentAsString()),
                () -> assertTrue(response.getContentAsString().contains("login"))
        );

    }

    @Test
    void fetchById() {
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