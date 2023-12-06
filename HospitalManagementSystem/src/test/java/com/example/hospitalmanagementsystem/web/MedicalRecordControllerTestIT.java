package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import com.example.hospitalmanagementsystem.service.NurseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class MedicalRecordControllerTestIT {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MedicalRecordService medicalRecordService;
    @MockBean
    private NurseService nurseService;
    @MockBean
    private ModelMapper modelMapper;

    @Test
    void testRegisterRecordForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/record/register"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view()
                        .name("register-medical-record"));
    }

//da gi proverq
    @Test
    void testRegisterRecordSuccess() throws Exception {
        MedicalRecordBindingModel mockBindingModel = new MedicalRecordBindingModel();
        mockBindingModel.setPatientEgn("1111");
        mockMvc.perform(MockMvcRequestBuilders.post("/record/register")
                .param("patientEgn", "1111"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
        Mockito.verify(medicalRecordService,
                Mockito.times(1)).registerRecord(mockBindingModel);
    }

    @Test
    void testRegisterRecordValidationFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/record/register"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/record/register"));

        Mockito.verify(medicalRecordService, Mockito.times(0))
                .registerRecord(Mockito.any());
    }

  /* @Test
    void testGetMedicalRecord() throws Exception {
        List<MedicalRecordViewModel> mockRecords = Collections
                .singletonList(new MedicalRecordViewModel());
        Mockito.when(medicalRecordService.getAllRecords()).thenReturn(mockRecords);
        mockMvc.perform(MockMvcRequestBuilders.get("/current-records"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("medical-record-view"))
                .andExpect(MockMvcResultMatchers.model().attribute("records", mockRecords));
    }*/
    }

