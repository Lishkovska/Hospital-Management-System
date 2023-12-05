package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.bindingModels.PatientRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.models.service.PatientServiceModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.service.KitchenService;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.PatientService;
import com.example.hospitalmanagementsystem.service.WardService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Transactional
    public void registerPatient(PatientRegisterBindingModel patientRegisterBindingModel, UserDetails userDetails) {
        Patient patient = modelMapper.map(patientRegisterBindingModel, Patient.class);
        patient.setMenu(kitchenService.findByTypeOfMenu(patientRegisterBindingModel.getMenu()));
        patient.setWard(wardService.findByWardNameEnum(patientRegisterBindingModel.getWard()));
        NurseEntity currentNurse = nurseService.findNurseByUsername(userDetails.getUsername());
        patient.setNurse(currentNurse);
      //  patient.setNurse(nurseService.findByNurseId(patientServiceModel.getNurse().getId()));

        patientRepository.saveAndFlush(patient);
        currentNurse.getPatientList().add(patient);
        nurseService.save(currentNurse);

    }


    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElse(null);
    }


//todo




    @Override
    public void removePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientViewModel> getAllPatients() {
        return patientRepository.findAll().stream().map(patient-> new PatientViewModel(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getWard().getName().name(),
                patient.getMenu().getTypeOfMenu().name()
        )).collect(Collectors.toList());
    }


}
