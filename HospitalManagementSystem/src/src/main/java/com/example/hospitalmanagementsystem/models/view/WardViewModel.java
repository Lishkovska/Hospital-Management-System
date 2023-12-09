package com.example.hospitalmanagementsystem.models.view;

import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;

public class WardViewModel {
    private Ward ward;
    private Integer countOfPatients;

    public WardViewModel() {
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Integer getCountOfPatients() {
        return countOfPatients;
    }

    public void setCountOfPatients(Integer countOfPatients) {
        this.countOfPatients = countOfPatients;
    }

    public void setWard(WardEnum name) {
        Ward wardd = new Ward();
        wardd.setName(name);
    }
}
