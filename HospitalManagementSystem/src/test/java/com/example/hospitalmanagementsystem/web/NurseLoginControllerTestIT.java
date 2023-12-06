package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.service.NurseService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
@SpringBootTest
@AutoConfigureMockMvc
class NurseLoginControllerTestIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NurseService nurseServiceTest;

    @MockBean
    private ModelMapper modelMapperTest;



    @Test
    @WithAnonymousUser
    void testLoginGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nurses/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-login"));
    }



//ne raboti
    @Test
    @WithAnonymousUser
    void testLoginSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/nurses/login-error")
                        .param("username", "Sisito")
                        .param("password", "12345"))


                .andExpect(status().isOk());
    }

}