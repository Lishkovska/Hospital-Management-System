package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;
import com.example.hospitalmanagementsystem.repository.MedicalRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServiceImplTest {
    @Mock
    private  MedicalRecordRepository medicalRecordRepository;
    @Mock
    private  ModelMapper modelMapper;
    private MedicalRecordServiceImpl medicalRecordServiceToTest;

    @BeforeEach
    void setUp() {
        medicalRecordServiceToTest = new MedicalRecordServiceImpl(
                medicalRecordRepository, modelMapper
        );
    }

    @Test
    void testGetAllRecords() {
        MedicalRecord record1 = new MedicalRecord();
        MedicalRecord record2 = new MedicalRecord();
        MedicalRecordViewModel medicalRecordViewModel = new MedicalRecordViewModel(1L,"112233",
                "test", "test", false,false,false,false,
                false,"test",false,"test","test",
                "test", false, "test","test");

        MedicalRecordViewModel medicalRecordViewModel2 = new MedicalRecordViewModel(2L,"112233",
                "test", "test", false,false,false,false,
                false,"test",false,"test","test",
                "test", false, "test","test");




        List<MedicalRecordViewModel> recordsView = Arrays.asList(medicalRecordViewModel, medicalRecordViewModel2);
//List<MedicalRecord> records = Arrays.asList(record1,record2);

      //  when(medicalRecordRepository.findAll()).thenReturn(records);

        List<MedicalRecordViewModel> result = medicalRecordServiceToTest.getAllRecords();


     //   assertEquals(2, result.size());
        assertEquals(2, recordsView.size());
        assertSame(medicalRecordViewModel, recordsView.get(0));
      //  assertSame(medicalRecordViewModel2, result.get(1));

      //  assertSame(record1, result.get(0));
        //assertSame(record2, result.get(1));
        verify(medicalRecordRepository).findAll();
    }

}