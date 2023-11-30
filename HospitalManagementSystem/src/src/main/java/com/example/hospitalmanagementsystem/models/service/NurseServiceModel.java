package com.example.hospitalmanagementsystem.models.service;

import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.entity.UserRole;
import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class NurseServiceModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
  //  private Set<UserRole> roles;
    private int age;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String fullAddress;
    private Integer professionalNumber;
    private String speciality;
    private String education;
    private String lastJobOccupation;
    private WardEnum ward;
    private List<Patient> patientList;

    public NurseServiceModel() {
    }

  //  public Set<UserRole> getRoles() {
    //    return roles;
    //}

    //public void setRoles(Set<UserRole> roles) {
      //  this.roles = roles;
    //}

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getProfessionalNumber() {
        return professionalNumber;
    }

    public void setProfessionalNumber(Integer professionalNumber) {
        this.professionalNumber = professionalNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLastJobOccupation() {
        return lastJobOccupation;
    }

    public void setLastJobOccupation(String lastJobOccupation) {
        this.lastJobOccupation = lastJobOccupation;
    }

    public WardEnum getWard() {
        return ward;
    }

    public void setWard(WardEnum ward) {
        this.ward = ward;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
