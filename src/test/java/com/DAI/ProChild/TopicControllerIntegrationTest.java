package com.DAI.ProChild;

import com.DAI.ProChild.Topic.Topic;
import com.DAI.ProChild.Topic.TopicController;
import com.DAI.ProChild.Topic.TopicService;
import com.DAI.ProChild.User.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TopicController.class)
public class TopicControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private Gson gson = new Gson();

    @MockBean
    private TopicService topicService;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void RegisterTopicControllerTest() throws Exception{

        Topic topic = new Topic();
        topic.setTitle("direitos da criança");

        mockMvc.perform(post("/RegisterTopic")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(topic)))
                .andExpect(status().isOk());
        reset(topicService);
    }

}
