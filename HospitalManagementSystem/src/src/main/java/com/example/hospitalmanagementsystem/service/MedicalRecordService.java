package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.service.MedicalRecordServiceModel;


public interface MedicalRecordService {
    void registerRecord(MedicalRecordServiceModel medicalRecordServiceModel);

    void registerRecord(MedicalRecordBindingModel medicalRecordBindingModel);
}
