package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.service.PatientServiceModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;

import java.util.List;

public interface PatientService {
    void registerPatient(PatientServiceModel patientServiceModel);

    Patient findById(Long id);

    List<PatientViewModel> findMyPatients(Long id);
    void removePatientById(Long id);

}
