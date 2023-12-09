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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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



}