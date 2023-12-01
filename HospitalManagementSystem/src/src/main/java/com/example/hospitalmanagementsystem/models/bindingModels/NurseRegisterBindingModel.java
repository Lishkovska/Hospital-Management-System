package com.example.hospitalmanagementsystem.models.bindingModels;

import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NurseRegisterBindingModel {
      @Size(min = 3, max = 20)
        private String firstName;
        @Size(min = 5, max = 20)
        private String lastName;
        @Size(min = 5, max = 20)
        @NotNull
        private String username;
        @Size(min = 3)
        private String password;
        @Size(min = 3)
        private String confirmPassword;
        @Positive
      //  @Digits(max = 100)
        private int age;
        @Past
        private LocalDate dateOfBirth;

        private String phoneNumber;
        @NotNull
        private String fullAddress;
        @Positive
        private Integer professionalNumber;
        @NotNull
        private String speciality;

        private String education;

        private String lastJobOccupation;
        @NotNull
        private WardEnum ward;

        private List<Long> allNursesIDs = new ArrayList<>();

    public NurseRegisterBindingModel() {
    }

    public List<Long> getAllNursesIDs() {
        return allNursesIDs;
    }

    public void setAllNursesIDs(List<Long> allNursesIDs) {
        this.allNursesIDs = allNursesIDs;
    }

    public NurseRegisterBindingModel addNurseId(Long nurseId) {
        this.allNursesIDs.add(nurseId);
        return this;
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

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


