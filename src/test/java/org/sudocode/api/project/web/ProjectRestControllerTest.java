package org.sudocode.api.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.sudocode.api.project.Project;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentDTO;
import org.sudocode.api.project.comment.CommentMapper;
import org.sudocode.api.user.User;
import org.sudocode.api.user.web.UserDTO;
import org.sudocode.api.user.web.UserMapper;

import java.io.IOException;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.sudocode.api.project.Difficulty.EXPERT;

//@ExtendWith({SpringExtension.class, MockitoExtension.class})
//@WebMvcTest(value = ProjectRestController.class, secure = false)
//@EnableSpringDataWebSupport
//@MockitoSettings(strictness = Strictness.STRICT_STUBS)
//@ActiveProfiles("test")
//class ProjectRestControllerTest {
//
//    @Autowired private MockMvc mockMvc;
//    @Autowired private ObjectMapper objectMapper;
//    @MockBean private ProjectService projectService;
//    @MockBean private ProjectMapper projectMapper;
//    @MockBean private CommentMapper commentMapper;
//    @MockBean private UserMapper userMapper;
//
//    private JacksonTester<ProjectDTO> projectDTOJacksonTester;
//    private JacksonTester<Project> jsonProject;
//    private JacksonTester<Page<ProjectSummaryDTO>> jacksonTestSummaryPage;
//    private JacksonTester<ProjectSummaryDTO> jsonSummaryDTO;
//    private JacksonTester<Page<CommentDTO>> jsonCommentDTOPage;
//    private JacksonTester<CommentDTO> jsonCommentDTO;
//    private JacksonTester<Comment> jsonComment;
//
//    private User user;
//    private UserDTO userDTO;
//
//    private Project project;
//    private ProjectDTO projectDTO;
//
//    private ProjectSummaryDTO projectSummaryDTO;
//    private Page<ProjectSummaryDTO> projectSummaryDTOPage;
//
//    private Comment comment;
//    private CommentDTO commentDTO;
//    private Page<Comment> commentPage;
//    private Page<CommentDTO> commentDTOPage;
//
//    private String projectSummaryDTOPage_expectedJson;
//    private String projectDTO_expectedJson;
//    private String commentDTOPage_expectedJson;
//
//    @BeforeEach
//    void setUp() throws IOException {
//        JacksonTester.initFields(this, objectMapper);
//
//        user = User.builder().id(1L).login("mockLogin").build();
//        project = Project.builder(user).id(1L).title("mockTitle").build();
//        comment = Comment.builder().id(1L).author(user).project(project).body("Original Comment").build();
//
//
//        userDTO = new UserDTO(user);
//        projectDTO = new ProjectDTO(project);
//        commentDTO = new CommentDTO(comment);
//        projectSummaryDTO = new ProjectSummaryDTO(project);
//
//
//        projectSummaryDTOPage = new PageImpl<>(List.of(projectSummaryDTO), PageRequest.of(0, 20), 1);
//        commentPage = new PageImpl<>(List.of(comment), PageRequest.of(0, 20), 1);
//        commentDTOPage = commentPage.map(CommentDTO::new);
//
////        given(projectService.fetchById(project.getId())).willReturn(project);
//        given(projectMapper.toDTO(project)).willReturn(projectDTO);
//        given(commentMapper.toDTO(comment)).willReturn(commentDTO);
//
//
//        projectSummaryDTOPage_expectedJson = jacksonTestSummaryPage.write(projectSummaryDTOPage).getJson();
//        projectDTO_expectedJson = projectDTOJacksonTester.write(projectDTO).getJson();
//        commentDTOPage_expectedJson = jsonCommentDTOPage.write(commentDTOPage).getJson();
//    }
//
//
//    @Test
//    void response_FetchAll() throws Exception {
////        given(projectService.fetchAll(any(), any(), any(), any())).willReturn(projectSummaryDTOPage);
//
//        mockMvc.perform(get("/api/projects"))
//               .andExpect(status().isOk())
//               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//               .andExpect(content().json(projectSummaryDTOPage_expectedJson))
//               .andDo(print());
//
//    }
//
//    @Test
//    void response_FetchById() throws Exception {
//        mockMvc.perform(get("/api/projects/1")
//                .accept(MediaType.APPLICATION_JSON))
//               .andExpect(status().isOk())
//               .andExpect(content().json(projectDTO_expectedJson))
//               .andDo(print());
//
//    }
//
//    @Test
//    void response_PostProject() throws Exception {
//        given(projectService.postProject(any(Project.class))).willReturn(project);
//
//        String jsonSubmission = jsonProject.write(project).getJson();
//
//        mockMvc.perform(post("/api/projects")
//                .content(jsonSubmission)
//                .contentType(MediaType.APPLICATION_JSON))
//               .andExpect(status().isOk())
//               .andExpect(content().json(projectDTO_expectedJson));
//    }
//
//    @Test
//    void response_FetchComments() throws Exception {
////        given(projectService.fetchCommentsByProjectId(any(), any(Pageable.class))).willReturn(commentPage);
//
//        mockMvc.perform(get("/api/projects/{id}/comments", 1))
//               .andExpect(status().isOk())
//               .andExpect(content().json(commentDTOPage_expectedJson))
//               .andDo(print());
//    }
//
//    @Test
//    void response_PostComment() throws Exception {
//        given(projectService.postComment(any(Comment.class), any(Long.class), any(User.class))).willReturn(comment);
//
//        String commentJson = jsonComment.write(comment).getJson();
//
//        mockMvc.perform(post("/api/projects/1/comments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(commentJson))
//               .andExpect(status().isOk())
//               .andExpect(content().json(jsonCommentDTO.write(commentDTO).getJson()));
//
//    }
//
//    @Test
//    void response_UpdateComment() throws Exception {
//        given(projectService.updateComment(any(Comment.class), any(Long.class), any(Long.class), any(User.class))).willReturn(comment);
//
//        mockMvc.perform(put("/api/projects/1/comments/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonComment.write(comment).getJson()))
//               .andExpect(status().is2xxSuccessful())
//               .andExpect(content().json(jsonCommentDTO.write(commentDTO).getJson()))
//               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
//    }
//
//    @Test
//    void deleteCommentById_noException_thenNoContent204() throws Exception {
//        doNothing().when(projectService).deleteCommentById(any(), any());
//
//        mockMvc.perform(delete("/api/projects/1/comments/1"))
//               .andExpect(status().isNoContent());
//    }
//
//    @Test
//    void updateProject() throws Exception {
//        given(projectService.updateProject(any(), any(Project.class), any(User.class))).willReturn(project);
//        mockMvc.perform(put("/api/projects/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonProject.write(project).getJson()))
//               .andExpect(status().is2xxSuccessful())
//               .andExpect(content().json(projectDTO_expectedJson))
//               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
//    }
//
//    @Test
//    void deleteProject() {
//    }
//}