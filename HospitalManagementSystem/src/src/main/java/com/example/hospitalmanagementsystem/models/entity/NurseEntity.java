package com.example.hospitalmanagementsystem.models.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "nurses")
public class NurseEntity extends BaseEntity{
    @Column(nullable = false, name = "first_name")

    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "nurses_roles", joinColumns = @JoinColumn(name = "nurse_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRole> roles = new ArrayList<>();

    @Column(nullable = false)
    private int age;
    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false, name = "full_address", columnDefinition = "text")
    private String fullAddress;
    @Column(nullable = false, name = "professional_number", unique = true)
    private Integer professionalNumber;
    @Column(nullable = false)
    private String speciality;
    @Column(nullable = false, columnDefinition = "text")
    private String education;
    @Column(name = "last_job")
    private String lastJobOccupation;
    @ManyToOne
    private Ward ward;
    @OneToMany(mappedBy = "nurse", fetch = FetchType.EAGER)
    private List<Patient> patientList;

    public NurseEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
