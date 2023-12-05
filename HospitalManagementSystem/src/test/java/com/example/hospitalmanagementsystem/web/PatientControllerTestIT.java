package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.bindingModels.PatientRegisterBindingModel;
import com.example.hospitalmanagementsystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTestIT {

    @Autowired
    private MockMvc mockMvc;



    @Autowired
    private PatientService patientService;

  /*  @Test
    @WithMockUser(username = "Sisito", password = "12345", roles = "USER")
    public void testPatientRegistration() throws Exception {
        PatientRegisterBindingModel patient = new PatientRegisterBindingModel();
        patient.setEgn("112233");
        patient.setAge(45);
        patient.setBedNumber(1);
        patient.setContactPersonFullName("test");
        // Set patient details


        ResultActions result = mockMvc.perform(post("/patient/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/record/register"));
    }*/

    @Test
    @WithMockUser(username = "Sisito", password = "12345", roles = "USER")
    public void testGetAllPatients() throws Exception {
        ResultActions result = mockMvc.perform(get("/patient/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient-view-model"))
                .andExpect(model().attributeExists("patients"));

        // Additional assertions if necessary
    }

    @Test
    @WithMockUser(username = "Sisito", password = "12345", roles = "USER")
    public void testGetPatientByIdNotFound() throws Exception {
        Long nonExistentPatientId = 100L;

        mockMvc.perform(get("/patient/{id}", nonExistentPatientId))
                .andExpect(status().isNotFound())
                .andExpect(view().name("patient-not-found"))
                .andExpect(model().attribute("id", nonExistentPatientId));

        // Additional assertions if necessary
    }
}





