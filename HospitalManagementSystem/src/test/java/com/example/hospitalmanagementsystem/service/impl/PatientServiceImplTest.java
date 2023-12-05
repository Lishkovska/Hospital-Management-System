package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.bindingModels.PatientRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.service.KitchenService;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.PatientService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {
    private final Long ID = Long.valueOf(1);

    private PatientService patientServiceToTest;

    @Mock
    private PatientRepository patientRepositoryMock;
    @Mock
    private  ModelMapper modelMapperMock;
    @Mock
    private NurseService nurseServiceMock;
    @Mock
    private  KitchenService kitchenServiceMock;
    @Mock
    private  WardService wardServiceMock;

    @BeforeEach
    void setUp() {
        patientServiceToTest = new PatientServiceImpl(
                patientRepositoryMock,modelMapperMock,nurseServiceMock,kitchenServiceMock,wardServiceMock
        );
    }

    @Test
    void testFindPatientById() {
        Patient patientToTest = new Patient();
        Long id = Long.valueOf(1);
       patientToTest.setId(Long.valueOf(1));

        when(patientRepositoryMock.findById(id))
                .thenReturn(Optional.of(patientToTest));


        patientServiceToTest.findById(ID);
    }

    @Test
    void findById_PatientNotFound_ReturnsNull() {
        // Arrange
        Long patientId = 1L;
        when(patientRepositoryMock.findById(patientId)).thenReturn(Optional.empty());

        // Act
        Patient result = patientServiceToTest.findById(patientId);

        // Assertb
        assertNull(result);
    }



    }


