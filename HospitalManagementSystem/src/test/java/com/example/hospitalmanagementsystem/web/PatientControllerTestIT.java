package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest
class PatientControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    //ne raaboti

    @Test
    @WithMockUser
    void testRegisterEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register-patient"));
    }


    @Test
    @WithMockUser
    void testGetAllPatientsEndpoint() throws Exception {
        // Mock the service response
        List<PatientViewModel> mockPatients = Arrays.asList(
                new PatientViewModel(1L, "Test", "test", "Cardiology", "normal"),
                new PatientViewModel(2L, "Jane", "Sstee", "Orthopedics", "normal")
                // Add more mock data as needed
        );
        Mockito.when(patientService.getAllPatients()).thenReturn(mockPatients);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("patient-view-model"))
                // You can add more assertions based on the expected behavior
                .andExpect(MockMvcResultMatchers.model().attribute("patients", mockPatients));
    }

}