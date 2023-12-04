package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.event.NurseCreateEvent;
import com.example.hospitalmanagementsystem.exceptionHandler.NurseNotFoundException;
import com.example.hospitalmanagementsystem.models.bindingModels.NurseRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.enums.RoleEnum;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.repository.NurseRepository;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.repository.UserRoleRepository;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.ArrayList;

@Service
public class NurseServiceImpl implements NurseService {
    private final NurseRepository nurseRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final WardService wardService;
    private final PatientRepository patientRepository;

    private final UserRoleRepository userRoleRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(NurseService.class);
    private final ApplicationEventPublisher appEventPublisher;

    public NurseServiceImpl(NurseRepository nurseRepository, PasswordEncoder passwordEncoder,
                            ModelMapper modelMapper, WardService wardService,
                            PatientRepository patientRepository,
                            UserRoleRepository userRoleRepository, ApplicationEventPublisher appEventPublisher) {
        this.nurseRepository = nurseRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.wardService = wardService;
        this.patientRepository = patientRepository;
        this.userRoleRepository = userRoleRepository;
        this.appEventPublisher = appEventPublisher;
    }


    @Override
    public void registerNurse(NurseRegisterBindingModel nurseRegisterBindingModel) {
        NurseEntity nurse = modelMapper.map(nurseRegisterBindingModel, NurseEntity.class);
        nurse.setPassword(passwordEncoder.encode(nurseRegisterBindingModel.getPassword()));
        nurse.setRoles(userRoleRepository.findByRole(RoleEnum.USER).orElse(null));
        nurse.setWard(wardService.findByWardNameEnum(nurseRegisterBindingModel.getWard()));
        nurse.setPatientList(new ArrayList<>());
               //(nurseServiceModel.getPatientList());

        nurseRepository.saveAndFlush(nurse);

        LOGGER.info("Nurse was registered.");

        NurseCreateEvent nurseCreateEvent = new NurseCreateEvent(this);


        appEventPublisher.publishEvent(nurseCreateEvent);
    }

    @Override
    public boolean findByUsername(String username) {
        return nurseRepository
                .findByUsername(username)
                .isPresent();
    }

    @Override
    public NurseEntity findNurseByUsername(String username) {
        return nurseRepository
                .findByUsername(username).orElse(null);
    }


    @Override
    public NurseEntity getNurse(String username) {
        return nurseRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nurse with " + username + " not found!"));
    }


    @Override
    public void save(NurseEntity currentNurse) {
        nurseRepository.saveAndFlush(currentNurse);
    }



}
