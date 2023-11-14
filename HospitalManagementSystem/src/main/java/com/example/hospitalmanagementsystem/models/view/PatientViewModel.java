package com.example.hospitalmanagementsystem.models.view;

import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;
import com.example.hospitalmanagementsystem.models.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.models.entity.Ward;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class PatientViewModel {

    private Long id;
    private String firstName;
    private String lastName;
    private Ward ward;
    private KitchenCatering menu;

    public PatientViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }


    public KitchenCatering getMenu() {
        return menu;
    }

    public void setMenu(KitchenCatering menu) {
        this.menu = menu;
    }
}
