package com.example.hospitalmanagementsystem.models.bindingModels;

import com.example.hospitalmanagementsystem.models.entity.*;
import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public class PatientRegisterBindingModel {
    @Size(min = 3, max = 20)
    private String firstName;

    @Size(min = 5, max = 20)
    private String lastName;
    private String sex;
    @Positive
    private int age;
    @NotNull
    private LocalDate dateOfBirth;

    private String egn; // da promenq imeto ako trqbva
    @NotNull
    private String phoneNumber;
    @NotNull
    private String fullAddress;
    @NotNull
    private String occupation;
    @NotNull
    private String contactPersonFullName;
    @NotNull
    private Integer contactNumberPhoneNumber;
    @NotNull
    private boolean isHealthInsured;
    @NotNull
    private WardEnum ward;
    private Integer bedNumber;

    private Integer roomNumber;
    @NotNull
    private TypeOfMenu menu;
    @PastOrPresent
    private LocalDate hospitalAdmission;
    @Future
    private LocalDate discharge;

    private NurseEntity nurse;

    public PatientRegisterBindingModel() {
    }

    public NurseEntity getNurse() {
        return nurse;
    }

    public void setNurse(NurseEntity nurse) {
        this.nurse = nurse;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContactPersonFullName() {
        return contactPersonFullName;
    }

    public void setContactPersonFullName(String contactPersonFullName) {
        this.contactPersonFullName = contactPersonFullName;
    }

    public Integer getContactNumberPhoneNumber() {
        return contactNumberPhoneNumber;
    }

    public void setContactNumberPhoneNumber(Integer contactNumberPhoneNumber) {
        this.contactNumberPhoneNumber = contactNumberPhoneNumber;
    }

    public boolean isHealthInsured() {
        return isHealthInsured;
    }

    public void setHealthInsured(boolean healthInsured) {
        isHealthInsured = healthInsured;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public WardEnum getWard() {
        return ward;
    }

    public void setWard(WardEnum ward) {
        this.ward = ward;
    }

    public TypeOfMenu getMenu() {
        return menu;
    }

    public void setMenu(TypeOfMenu menu) {
        this.menu = menu;
    }

    public LocalDate getHospitalAdmission() {
        return hospitalAdmission;
    }

    public void setHospitalAdmission(LocalDate hospitalAdmission) {
        this.hospitalAdmission = hospitalAdmission;
    }

    public LocalDate getDischarge() {
        return discharge;
    }

    public void setDischarge(LocalDate discharge) {
        this.discharge = discharge;
    }
}
