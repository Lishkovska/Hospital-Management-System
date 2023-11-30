package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import com.example.hospitalmanagementsystem.models.view.WardViewModel;

import java.util.List;

public interface WardService {
    void initWardName();

    Ward findByWardNameEnum(WardEnum wardEnum);
    List<WardViewModel> findAllPatientsAndCount();
}
