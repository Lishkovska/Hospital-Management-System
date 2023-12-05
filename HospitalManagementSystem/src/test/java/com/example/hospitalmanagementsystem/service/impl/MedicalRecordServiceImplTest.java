package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;
import com.example.hospitalmanagementsystem.repository.MedicalRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServiceImplTest {
    @Mock
    private  MedicalRecordRepository medicalRecordRepository;
    @Mock
    private  ModelMapper modelMapper;
    @InjectMocks
    private MedicalRecordServiceImpl medicalRecordServiceToTest;

    @BeforeEach
    void setUp() {
        medicalRecordServiceToTest = new MedicalRecordServiceImpl(
                medicalRecordRepository, modelMapper
        );
    }

    @Test
    void testGetAllRecords() {

        MedicalRecordViewModel medicalRecordViewModel = new MedicalRecordViewModel(1L,"112233",
                "test", "test", false,false,false,false,
                false,"test",false,"test","test",
                "test", false, "test","test");

        MedicalRecordViewModel medicalRecordViewModel2 = new MedicalRecordViewModel(2L,"112233",
                "test", "test", false,false,false,false,
                false,"test",false,"test","test",
                "test", false, "test","test");




        List<MedicalRecordViewModel> recordsView = Arrays.asList(medicalRecordViewModel, medicalRecordViewModel2);

        List<MedicalRecordViewModel> result = medicalRecordServiceToTest.getAllRecords();

        assertEquals(2, recordsView.size());
        assertSame(medicalRecordViewModel, recordsView.get(0));
        verify(medicalRecordRepository).findAll();
    }


    @Test
    void registerRecord_shouldSaveMedicalRecord() {
        // Arrange
        MedicalRecordBindingModel bindingModel = new MedicalRecordBindingModel();
        bindingModel.setHasDiabetic(true);
        bindingModel.setHasAllergies(false);
        bindingModel.setPatientEgn("554412");
        bindingModel.setMainDiagnosis("test");
        bindingModel.setAccompanyingIlness("test");
        bindingModel.setHasCurrentMedications(false);


        MedicalRecord mappedMedicalRecord = new MedicalRecord();
        mappedMedicalRecord.setHasDiabetic(true);
        mappedMedicalRecord.setHasAllergies(false);
        mappedMedicalRecord.setPatientEgn("554412");
        mappedMedicalRecord.setMainDiagnosis("test");
        mappedMedicalRecord.setAccompanyingIlness("test");
        mappedMedicalRecord.setHasCurrentMedications(false);


        when(modelMapper.map(bindingModel, MedicalRecord.class)).thenReturn(mappedMedicalRecord);

        // Act
        medicalRecordServiceToTest.registerRecord(bindingModel);

        // Assert
        verify(medicalRecordRepository, times(1)).save(mappedMedicalRecord);
    }

    @Test
    void getAllRecords_shouldReturnMedicalRecordViewModelList() {
        // Arrange
        MedicalRecord record1 = new MedicalRecord();
        record1.setHasDiabetic(true);
        record1.setHasAllergies(false);
        record1.setPatientEgn("55555");
        record1.setMainDiagnosis("test");
        record1.setAccompanyingIlness("test");
        record1.setHasCurrentMedications(false);

        MedicalRecord record2 = new MedicalRecord();
        record1.setHasDiabetic(true);
        record1.setHasAllergies(false);
        record1.setPatientEgn("55555");
        record1.setMainDiagnosis("test2");
        record1.setAccompanyingIlness("test2");
        record1.setHasCurrentMedications(false);

        List<MedicalRecord> medicalRecords = Arrays.asList(record1, record2);

        when(medicalRecordRepository.findAll()).thenReturn(medicalRecords);

        List<MedicalRecordViewModel> result = medicalRecordServiceToTest.getAllRecords();

        // Assert
        assertEquals(2, result.size());
        assertEquals(true, record1.isHasDiabetic());
        assertEquals("55555", record1.getPatientEgn());

    }

}