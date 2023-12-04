package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.models.service.MedicalRecordServiceModel;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.repository.MedicalRecordRepository;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import com.example.hospitalmanagementsystem.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final ModelMapper modelMapper;
  

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository, ModelMapper modelMapper) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.modelMapper = modelMapper;

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

    @Override
    public List<MedicalRecordViewModel> getAllRecords() {
        return medicalRecordRepository.findAll().stream().map(record-> new MedicalRecordViewModel(
                record.getId(),
                record.getPatientEgn(),
                record.getMainDiagnosis(),
                record.getPastConditions(),
                record.isHasSmoke(),
                record.isHasDrink(),
                record.isHasDiabetic(),
                record.isHasHighPressure(),
                record.isHasAllergies(),
                record.getNameOfAllergies(),
                record.isHasCurrentMedications(),
                record.getNameOfMedications(),
                record.getFamilyIlnessHistory(),
                record.getAccompanyingIlness(),
                record.isHasSurgicalProceduresInThePast(),
                record.getNameOfPatSurgicalProceduresAndDate(),
                record.getOther()
        )).collect(Collectors.toList());
    }


}
