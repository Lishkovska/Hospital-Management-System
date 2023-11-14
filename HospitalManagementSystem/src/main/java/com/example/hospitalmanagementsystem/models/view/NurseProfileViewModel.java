package com.example.hospitalmanagementsystem.models.view;

import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;

import java.util.ArrayList;
import java.util.List;

public class NurseProfileViewModel {
    private String username;
    private String lastName;
    private String ward;
    private List<Patient> patients;

    public NurseProfileViewModel(String username, String lastName, String ward, List<Patient> patients) {
        this.username = username;
        this.lastName = lastName;
        this.ward = ward;
        this.patients = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
