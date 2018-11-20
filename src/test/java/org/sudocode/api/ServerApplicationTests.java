package org.sudocode.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.sudocode.api.post.web.PostingRestController;
import testingutils.ProjectViewMock;
import testingutils.WithMockOAuth2User;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ServerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostingRestController postingRestController;

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
        mockMvc.perform(get("/api/auth/user"))
               .andExpect(jsonPath("$.login", is("Patrick Ewing")))
               .andExpect(jsonPath("$.id", is(1))).andDo(print());

    }

}
