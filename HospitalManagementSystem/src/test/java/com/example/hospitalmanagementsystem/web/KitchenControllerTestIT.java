package com.example.hospitalmanagementsystem.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class KitchenControllerTestIT {
        @Autowired
        private MockMvc mockMvc;

    @Test
    void testIndexPageGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk()) .andExpect(view().name("index"));
    }

        @Test
        public void testGetAllMenus() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/kitchen/menu"))
                  //  .andExpect(status().isOk())
                    .andExpect(view().name("all-menus"));
        }

        @Test
        public void testGetNormalDiet() throws Exception {
            ResultActions resultActions = mockMvc.perform(get("/normal-diet"));

            resultActions

                    .andExpect(view().name("normal-diet"));
        }

        @Test
        public void testGetPevzner() throws Exception {
            ResultActions resultActions = mockMvc.perform(get("/pevzner"));

            resultActions
                    .andExpect(status().isOk())
                    .andExpect(view().name("pevzner"));
        }

        @Test
        public void testGetSpecificDiet() throws Exception {
            ResultActions resultActions = mockMvc.perform(get("/milk-gluten-puree"));

            resultActions
                    .andExpect(status().isOk())
                    .andExpect(view().name("milk-gluten-puree"));
        }
    }
