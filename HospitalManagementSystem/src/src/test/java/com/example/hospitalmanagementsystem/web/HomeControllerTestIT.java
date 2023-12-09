package com.example.hospitalmanagementsystem.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndexPageGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk()) .andExpect(view().name("index"));
    }




    @Test void testWardPageGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ward"))
                .andExpect(status().isOk()) .andExpect(view().name("ward"));
    }




}

