package com.example.hospitalmanagementsystem.models.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity{
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    private String sex;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false,unique = true)
    private String egn; // da promenq imeto ako trqbva
    @Column(nullable = false, name = "phone_number")
    private Integer phoneNumber;
    @Column(nullable = false, name = "full_address", columnDefinition = "text")
    private String fullAddress;
    private String occupation;
    @Column(nullable = false, name = "contact_person")
    private String contactPersonFullName;
    @Column(nullable = false, name = "contact_person_phone_number")
    private String contactNumberPhoneNumber;
    @Column
    private boolean isHealthInsured;
    @ManyToOne
    private MedicalRecord medicalRecord;
    @ManyToOne
    private Ward ward;
    @Column(name = "bed_number")
    private Integer bedNumber;
    @Column(name = "room_number")
    private Integer roomNumber;
    @ManyToOne
    private KitchenCatering menu;
    @Column(name = "hospital_admission")
    private LocalDate hospitalAdmission;
    @Column
    private LocalDate discharge;
    @ManyToOne
    private NurseEntity nurse;

    public Patient() {
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
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

    public String getContactNumberPhoneNumber() {
        return contactNumberPhoneNumber;
    }

    public void setContactNumberPhoneNumber(String contactNumberPhoneNumber) {
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

    public KitchenCatering getMenu() {
        return menu;
    }

    public void setMenu(KitchenCatering menu) {
        this.menu = menu;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
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
