package com.example.hospitalmanagementsystem.service;



import com.example.hospitalmanagementsystem.models.bindingModels.NurseRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;


public interface NurseService {


    void registerNurse(NurseRegisterBindingModel nurseRegisterBindingModel);

    boolean findByUsername(String username);
    NurseEntity findNurseByUsername(String username);


    NurseEntity getNurse(String username);

    void save(NurseEntity currentNurse);



}
