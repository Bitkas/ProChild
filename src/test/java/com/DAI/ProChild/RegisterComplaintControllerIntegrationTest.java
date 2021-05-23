package com.DAI.ProChild;

import com.DAI.ProChild.Complaint.Complaint;
import com.DAI.ProChild.Complaint.RegisterComplaintController;
import com.DAI.ProChild.Complaint_form.Complaint_Form;
import com.DAI.ProChild.Complaint.RegisterComplaintController;
import com.DAI.ProChild.Complaint.RegisterComplaintService;
import com.DAI.ProChild.User.User;
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

@WebMvcTest(RegisterComplaintController.class)
public class RegisterComplaintControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private Gson gson = new Gson();

    @MockBean
    private RegisterComplaintService registerComplaintService;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void RegisterFormComplaintControllerTest() throws Exception{
        Complaint_Form complaint_form =new Complaint_Form();


        mockMvc.perform(post("/Form")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(complaint_form)))
                .andExpect(status().isOk());
        reset(registerComplaintService);

    }
}
