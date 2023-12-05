package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.bindingModels.PatientRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.models.service.PatientServiceModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface PatientService {
 //   void registerPatient(PatientServiceModel patientServiceModel);

    Patient findById(Long id);

    void removePatientById(Long id);
    List<PatientViewModel> getAllPatients();

    void registerPatient(PatientRegisterBindingModel patientRegisterBindingModel, UserDetails userDetails);
}
