package com.example.hospitalmanagementsystem.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class KitchenControllerTestIT {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @WithMockUser
        void testRegisterEndpoint() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/kitchen/menu"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("all-menus"));
        }

        @Test
        @WithMockUser
        void testNormalMenuEndpoint() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/normal-diet"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("normal-diet"));
        }

        @Test
        @WithMockUser
        void testPevznerEndpoint() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/pevzner"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("pevzner"));
        }

        @Test
        @WithMockUser
        void testSpecificDietEndpoint() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/milk-gluten-puree"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("milk-gluten-puree"));
        }
    }

