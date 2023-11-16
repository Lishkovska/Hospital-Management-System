package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.service.PatientServiceModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.service.KitchenService;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.PatientService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;
    private final NurseService nurseService;
    private final KitchenService kitchenService;
    private final WardService wardService;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper, NurseService nurseService, KitchenService kitchenService, WardService wardService) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.nurseService = nurseService;
        this.kitchenService = kitchenService;
        this.wardService = wardService;
    }

    @Override
    public void registerPatient(PatientServiceModel patientServiceModel) {
        Patient patient = modelMapper.map(patientServiceModel, Patient.class);
        patient.setMenu(kitchenService.findByNameMenuEnum(patientServiceModel.getMenu()));
        patient.setWard(wardService.findByWardNameEnum(patientServiceModel.getWard()));
        patient.setNurse(patientServiceModel.getNurse());

        patientRepository.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElse(null);
    }
     //todo


  @Override
    public List<PatientViewModel> findMyPatients(Long id) {
        return patientRepository
                .findAllByNurseId(nurseService.findById(id).getId())
                .stream()
                .map(patient -> modelMapper.map(patient, PatientViewModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public void removePatientById(Long id) {
        patientRepository.deleteById(id);
    }


}
