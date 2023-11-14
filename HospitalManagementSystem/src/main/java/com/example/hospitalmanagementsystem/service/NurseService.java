package com.example.hospitalmanagementsystem.service;



import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.models.view.NurseViewModels;

import java.util.List;


public interface NurseService {


    void registerNurse(NurseServiceModel nurseServiceModel);

    boolean findByUsername(String username);

    NurseServiceModel findById(Long id);

    NurseEntity getNurse(String username);

    //List<NurseViewModels> findAllPatientsAndCount();//todo


}
