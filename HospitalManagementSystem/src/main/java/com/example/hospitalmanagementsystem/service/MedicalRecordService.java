package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;


import java.util.List;


public interface MedicalRecordService {


    void registerRecord(MedicalRecordBindingModel medicalRecordBindingModel);
    List<MedicalRecordViewModel> getAllRecords();

    void removeRecordById(Long id);
}
