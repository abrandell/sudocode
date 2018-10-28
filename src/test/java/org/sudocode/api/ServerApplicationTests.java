package org.sudocode.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.sudocode.api.post.project.Difficulty;
import org.sudocode.api.post.web.PostingRestController;
import testingutils.ProjectViewMock;
import testingutils.WithMockOAuth2User;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@ActiveProfiles("dev")
@WebAppConfiguration
@AutoConfigureTestDatabase
@ContextConfiguration
class ServerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostingRestController postingRestController;

    JacksonTester<ProjectViewMock> jsonProjectPost;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    void contextLoads() {
    }

    @Test
    @WithMockOAuth2User(name = "Patrick Ewing")
    void testFetchProjectById() throws Exception {

        var response = mockMvc.perform(get("/api/users/me"))
                              .andExpect(jsonPath("$.login", is("Patrick Ewing")))
                              .andExpect(jsonPath("$.id", is(1)))
                              .andDo(print()).andReturn().getResponse();

        Assertions.assertNotNull(response);
    }



}
