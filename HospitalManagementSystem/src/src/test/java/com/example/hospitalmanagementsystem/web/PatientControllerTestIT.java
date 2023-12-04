package com.example.hospitalmanagementsystem.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegisterPatientGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/register"))
                .andExpect(status().isOk())
              .andExpect(view().name("register-patient"));
    }




}