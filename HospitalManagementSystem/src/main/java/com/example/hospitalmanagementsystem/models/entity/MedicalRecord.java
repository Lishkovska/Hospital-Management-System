package com.example.hospitalmanagementsystem.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medical_records")
public class MedicalRecord extends BaseEntity{

    @Column(nullable = false, name = "patient_egn")
    private String patientEgn;
    @Column(nullable = false, name = "main_diagnosis", columnDefinition = "text")
    private String mainDiagnosis;
    @Column(nullable = false, name = "past_conditions", columnDefinition = "text")
    private String pastConditions;
    @Column
    private boolean isSmoke;
    @Column
    private boolean isDrink;
    @Column
    private boolean isDiabetic;
    @Column
    private boolean isHighPressure;
    @Column
    private boolean hasAllergies;
    @Column(name = "allergies", columnDefinition = "text")
    private String nameOfAllergies;
    @Column
    private boolean hasCurrentMedications;
    @Column(name = "medications", columnDefinition = "text")
    private String nameOfMedications;
    @Column(name = "family_ilness_history", columnDefinition = "text")
    private String familyIlnessHistory;
    @Column( name = "accompanying_ilness", columnDefinition = "text")
    private String accompanyingIlness;
    @Column
    private boolean hasSurgicalProceduresInThePast;
    @Column(name = "procedures_in_the_past", columnDefinition = "text")
    private String nameOfPatSurgicalProceduresAndDate;
    @Column(columnDefinition = "text")
    private String other;



    public MedicalRecord() {
    }

    public String getPatientEgn() {
        return patientEgn;
    }

    public void setPatientEgn(String patientEgn) {
        this.patientEgn = patientEgn;
    }

    public String getMainDiagnosis() {
        return mainDiagnosis;
    }

    public void setMainDiagnosis(String mainDiagnosis) {
        this.mainDiagnosis = mainDiagnosis;
    }

    public String getPastConditions() {
        return pastConditions;
    }

    public void setPastConditions(String pastConditions) {
        this.pastConditions = pastConditions;
    }

    public boolean isSmoke() {
        return isSmoke;
    }

    public void setSmoke(boolean smoke) {
        isSmoke = smoke;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }

    public boolean isDiabetic() {
        return isDiabetic;
    }

    public void setDiabetic(boolean diabetic) {
        isDiabetic = diabetic;
    }

    public boolean isHighPressure() {
        return isHighPressure;
    }

    public void setHighPressure(boolean highPressure) {
        isHighPressure = highPressure;
    }

    public boolean isHasAllergies() {
        return hasAllergies;
    }

    public void setHasAllergies(boolean hasAllergies) {
        this.hasAllergies = hasAllergies;
    }

    public String getNameOfAllergies() {
        return nameOfAllergies;
    }

    public void setNameOfAllergies(String nameOfAllergies) {
        this.nameOfAllergies = nameOfAllergies;
    }

    public boolean isHasCurrentMedications() {
        return hasCurrentMedications;
    }

    public void setHasCurrentMedications(boolean hasCurrentMedications) {
        this.hasCurrentMedications = hasCurrentMedications;
    }

    public String getNameOfMedications() {
        return nameOfMedications;
    }

    public void setNameOfMedications(String nameOfMedications) {
        this.nameOfMedications = nameOfMedications;
    }

    public String getFamilyIlnessHistory() {
        return familyIlnessHistory;
    }

    public void setFamilyIlnessHistory(String familyIlnessHistory) {
        this.familyIlnessHistory = familyIlnessHistory;
    }

    public String getAccompanyingIlness() {
        return accompanyingIlness;
    }

    public void setAccompanyingIlness(String accompanyingIlness) {
        this.accompanyingIlness = accompanyingIlness;
    }

    public boolean isHasSurgicalProceduresInThePast() {
        return hasSurgicalProceduresInThePast;
    }

    public void setHasSurgicalProceduresInThePast(boolean hasSurgicalProceduresInThePast) {
        this.hasSurgicalProceduresInThePast = hasSurgicalProceduresInThePast;
    }

    public String getNameOfPatSurgicalProceduresAndDate() {
        return nameOfPatSurgicalProceduresAndDate;
    }

    public void setNameOfPatSurgicalProceduresAndDate(String nameOfPatSurgicalProceduresAndDate) {
        this.nameOfPatSurgicalProceduresAndDate = nameOfPatSurgicalProceduresAndDate;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
