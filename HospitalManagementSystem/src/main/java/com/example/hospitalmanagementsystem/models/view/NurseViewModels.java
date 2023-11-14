package com.example.hospitalmanagementsystem.models.view;

public class NurseViewModels {
    private String username;
    private Integer countOfPatients;

    public NurseViewModels() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCountOfPatients() {
        return countOfPatients;
    }

    public void setCountOfPatients(Integer countOfPatients) {
        this.countOfPatients = countOfPatients;
    }
}
