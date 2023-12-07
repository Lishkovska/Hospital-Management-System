package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.service.NurseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class NurseControllerTestIT {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private NurseService nurseServiceTest;

    @Autowired
    private ModelMapper modelMapperTest;
//ne raboti
    @Test
    void testRegistrationSuccessful() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/nurses/register")
                                .param("username", "Sisito")
                                .param("password", "test")
                                .param("confirmPassword", "test")
                                .param("firstName", "Sisito")
                                .param("lastName", "Tomova")

                )//.andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/nurses/auth-login"));
    }


//ne raboti
    @Test void testRegisterConfirm_ValidData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/nurses/register")
                .param("username", "Sisito")
                .param("password", "12345")
                .param("confirmPassword", "12345"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("redirect:auth-login"));
    }

/*
    @Test
    void testRegisterConfirm_InvalidData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("username", "Sisito")
                .param("password", "12345")
                .param("confirmPassword", "123"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl
                        ("redirect:/nurses/register"))
                .andExpect(MockMvcResultMatchers.flash().
                        attributeExists( "nurseRegisterBindingModel",
                                "org.springframework.validation.BindingResult.nurseRegisterBindingModel"));
    }


    @Test void testRegisterConfirm_ExistingUsername() throws Exception { // Assume "testUser" already exists mockMvc.perform(MockMvcRequestBuilders.post("/register") .param("username", "testUser") .param("password",
        // "testPassword") .param("confirmPassword", "testPassword")) .andExpect(MockMvcResultMatchers.status().is3xxRedirection()) .andExpect(MockMvcResultMatchers.redirectedUrl("redirect:/nurses/register")); } }
//ne raboti
    @Test
    void testRegisterNurseToBeSuccessfull() throws Exception{
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/nurses/register")
                                .param("firstName", "Sisi")
                                .param("lastName", "Lishkovska")
                                .param("username", "Sisito")
                                .param("password", "topsecret")
                                .param("confirmPassword", "topsecret")
                                .param("age", "")
                                .param("phoneNumber", "111")
                                .param("fullAddress", "Pleven")
                                .param("professionalNumber", "111")
                                .param("speciality", "nurse")
                                .param("education", "nurse")
                                .param("lastJobOccupation", "nurse")
                                .param("ward", "oncology")
                                .param("ward", "oncology")

                ).andExpect(status().isOk()).
                andExpect(redirectedUrl("/nurses/login"));

    }*/


    @Test
    @WithAnonymousUser
    void testRegisterGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nurses/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-register"));
    }
    @Test
    @WithAnonymousUser
    void testLoginGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nurses/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-login"));
    }




}


