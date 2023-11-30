package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
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
        medicalRecord.setPatientEgn(medicalRecordServiceModel.getPatientEgn());
        medicalRecord.setHasDiabetic(medicalRecordServiceModel.isHasDiabetic());
        medicalRecord.setHasDrink(medicalRecordServiceModel.isHasDrink());
        medicalRecord.setHasCurrentMedications(medicalRecordServiceModel.isHasCurrentMedications());
        medicalRecord.setNameOfMedications(medicalRecordServiceModel.getNameOfMedications());
        medicalRecord.setAccompanyingIlness(medicalRecordServiceModel.getAccompanyingIlness());
        medicalRecord.setFamilyIlnessHistory(medicalRecordServiceModel.getFamilyIlnessHistory());
        medicalRecord.setHasAllergies(medicalRecordServiceModel.isHasAllergies());
        medicalRecord.setHasSurgicalProceduresInThePast(medicalRecordServiceModel.isHasSurgicalProceduresInThePast());
        medicalRecord.setHasHighPressure(medicalRecordServiceModel.isHasHighPressure());
        medicalRecord.setMainDiagnosis(medicalRecordServiceModel.getMainDiagnosis());
        medicalRecord.setNameOfAllergies(medicalRecordServiceModel.getNameOfMedications());
        medicalRecord.setNameOfPatSurgicalProceduresAndDate(medicalRecordServiceModel.getNameOfPatSurgicalProceduresAndDate());
        medicalRecord.setOther(medicalRecordServiceModel.getOther());
        medicalRecord.setPastConditions(medicalRecordServiceModel.getPastConditions());
        medicalRecord.setHasSmoke(medicalRecordServiceModel.isHasSmoke());

        medicalRecordRepository.save(medicalRecord);

    }

    @Override
    public void registerRecord(MedicalRecordBindingModel medicalRecordBindingModel) {
        MedicalRecord medicalRecord = modelMapper.map(medicalRecordBindingModel, MedicalRecord.class);
        medicalRecord.setPatientEgn(medicalRecordBindingModel.getPatientEgn());
        medicalRecord.setHasDiabetic(medicalRecordBindingModel.isHasDiabetic());
        medicalRecord.setHasDrink(medicalRecordBindingModel.isHasDrink());
        medicalRecord.setHasCurrentMedications(medicalRecordBindingModel.getHasCurrentMedications());
        medicalRecord.setNameOfMedications(medicalRecordBindingModel.getNameOfMedications());
        medicalRecord.setAccompanyingIlness(medicalRecordBindingModel.getAccompanyingIlness());
        medicalRecord.setFamilyIlnessHistory(medicalRecordBindingModel.getFamilyIlnessHistory());
        medicalRecord.setHasAllergies(medicalRecordBindingModel.getHasAllergies());
        medicalRecord.setHasSurgicalProceduresInThePast(medicalRecordBindingModel.getHasSurgicalProceduresInThePast());
        medicalRecord.setHasHighPressure(medicalRecordBindingModel.isHasHighPressure());
        medicalRecord.setMainDiagnosis(medicalRecordBindingModel.getMainDiagnosis());
        medicalRecord.setNameOfAllergies(medicalRecordBindingModel.getNameOfMedications());
        medicalRecord.setNameOfPatSurgicalProceduresAndDate(medicalRecordBindingModel.getNameOfPatSurgicalProceduresAndDate());
        medicalRecord.setOther(medicalRecordBindingModel.getOther());
        medicalRecord.setPastConditions(medicalRecordBindingModel.getPastConditions());
        medicalRecord.setHasSmoke(medicalRecordBindingModel.isHasSmoke());


     medicalRecordRepository.save(medicalRecord);
    }
}
