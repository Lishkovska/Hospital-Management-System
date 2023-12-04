package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.Patient;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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





}