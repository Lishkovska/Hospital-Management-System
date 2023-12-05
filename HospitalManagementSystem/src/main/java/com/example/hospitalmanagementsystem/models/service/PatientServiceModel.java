package com.example.hospitalmanagementsystem.models.service;

import com.example.hospitalmanagementsystem.models.entity.*;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class PatientServiceModel {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    private LocalDate dateOfBirth;
    private String egn; // da promenq imeto ako trqbva
    private String phoneNumber;
    private String fullAddress;
    private String occupation;
    private String contactPersonFullName;
    private Integer contactNumberPhoneNumber;
    private boolean isHealthInsured;
    private MedicalRecord medicalRecord;
    private WardEnum ward;
    private Integer bedNumber;
    private Integer roomNumber;

    private KitchenCatering menu;
    private LocalDate hospitalAdmission;
    private LocalDate discharge;
    private NurseEntity nurse;

    public PatientServiceModel() {
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

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public WardEnum getWard() {
        return ward;
    }

    public void setWard(WardEnum ward) {
        this.ward = ward;
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

    public KitchenCatering getMenu() {
        return menu;
    }

    public void setMenu(KitchenCatering menu) {
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

    public NurseEntity getNurse() {
        return nurse;
    }

    public void setNurse(NurseEntity nurse) {
        this.nurse = nurse;
    }
}
