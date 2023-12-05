package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.service.MedicalRecordServiceModel;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;

import java.util.List;


public interface MedicalRecordService {


    void registerRecord(MedicalRecordBindingModel medicalRecordBindingModel);
    List<MedicalRecordViewModel> getAllRecords();
}
