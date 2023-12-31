package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import com.example.hospitalmanagementsystem.service.WardService;
import com.example.hospitalmanagementsystem.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WardServiceImpl implements WardService {
    private final WardRepository wardRepository;

    public WardServiceImpl(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    @Override
    public void initWardName() {
        if(wardRepository.count() != 0){
            return;
        }
        Arrays.stream(WardEnum.values())
                .forEach(wardEnum -> {
                    Ward ward = new Ward();
                    ward.setBedCapacity(4);
                    ward.setName(wardEnum);
                    switch (wardEnum){
                        case GeneralSurgery -> ward.setRoomCapacity(5);
                        case Orthopedics -> ward.setRoomCapacity(10);
                        case Nephrology-> ward.setRoomCapacity(6);
                        case Cardiology -> ward.setRoomCapacity(8);
                        case Oncology -> ward.setRoomCapacity(7);
                    }
                    wardRepository.save(ward);
                });
    }

    @Override
    public Ward findByWardNameEnum(WardEnum wardEnum) {
        return wardRepository.findByName(wardEnum)
                .orElse(null);
    }

}
