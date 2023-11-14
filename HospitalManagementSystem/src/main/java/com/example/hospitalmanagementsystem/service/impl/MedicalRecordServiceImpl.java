package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.models.service.MedicalRecordServiceModel;
import com.example.hospitalmanagementsystem.repository.MedicalRecordRepository;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import com.example.hospitalmanagementsystem.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final ModelMapper modelMapper;
    private final PatientService patientService;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository, ModelMapper modelMapper, PatientService patientService) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.modelMapper = modelMapper;
        this.patientService = patientService;
    }

    @Override
    public void registerRecord(MedicalRecordServiceModel medicalRecordServiceModel) {
        MedicalRecord medicalRecord = modelMapper.map(medicalRecordServiceModel, MedicalRecord.class);



     medicalRecordRepository.save(medicalRecord);
    }
}
