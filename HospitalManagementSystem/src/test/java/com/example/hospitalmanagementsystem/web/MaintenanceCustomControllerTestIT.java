package com.example.hospitalmanagementsystem.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MaintenanceCustomControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void testMaintenanceGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/maintenance"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("maintenance-custom-interseptor"));
    }
}

