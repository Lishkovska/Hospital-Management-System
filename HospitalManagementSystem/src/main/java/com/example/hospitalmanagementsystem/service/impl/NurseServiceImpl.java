package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.models.view.NurseViewModels;
import com.example.hospitalmanagementsystem.repository.NurseRepository;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NurseServiceImpl implements NurseService {
    private final NurseRepository nurseRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final WardService wardService;
    private final PatientRepository patientRepository;

    public NurseServiceImpl(NurseRepository nurseRepository, PasswordEncoder passwordEncoder,
                            ModelMapper modelMapper, WardService wardService, PatientRepository patientRepository) {
        this.nurseRepository = nurseRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.wardService = wardService;

        this.patientRepository = patientRepository;
    }


    @Override
    public void registerNurse(NurseServiceModel nurseServiceModel) {
        NurseEntity nurse = modelMapper.map(nurseServiceModel, NurseEntity.class);
        nurse.setPassword(passwordEncoder.encode(nurseServiceModel.getPassword()));
        nurse.setWard(wardService.findByWardNameEnum(nurseServiceModel.getWard()));
       nurse.setPatientList(nurseServiceModel.getPatientList());


        nurseRepository.save(nurse);
    }

    @Override
    public boolean findByUsername(String username) {
        return nurseRepository
                .findByUsername(username)
                .isPresent();
    }

    @Override
    public NurseServiceModel findById(Long id) {
        return nurseRepository.findById(id)
                .map(nurse -> modelMapper.map(nurse, NurseServiceModel.class))
                .orElse(null);
    }

    @Override
    public NurseEntity getNurse(String username) {
        return nurseRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nurse with " + username + " not found!"));
    }

    /*@Override //todo
    public List<NurseViewModels> findAllPatientsAndCount() {
        return null;
    }

   /* @Override   todo
    public List<NurseViewModels> findAllPatientsAndCount() {
        return nurseRepository.findAllByAndCount()
                .stream()
                .map(nurseEntity -> {
                    NurseViewModels nurseViewModels =  new NurseViewModels();
                    nurseViewModels.setUsername(nurseEntity.getUsername());
                    nurseViewModels.setCountOfPatients(nurseEntity.getPatientList().size());

                    return nurseViewModels;
                }).collect(Collectors.toList());
    } */


}
