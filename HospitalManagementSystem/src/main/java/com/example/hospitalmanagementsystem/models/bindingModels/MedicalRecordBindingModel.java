package com.example.hospitalmanagementsystem.models.bindingModels;

import com.example.hospitalmanagementsystem.models.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

public class MedicalRecordBindingModel {
    @NotNull
    private String patientEgn;
    @NotNull
    private String mainDiagnosis;
    private String pastConditions;
   // @NotNull
    private boolean hasSmoke;
  //  @NotNull
    private boolean hasDrink;
  //  @NotNull
    private boolean hasDiabetic;
  //  @NotNull
    private boolean hasHighPressure;
  //  @NotNull
    private boolean hasAllergies;

    private String nameOfAllergies;
  //  @NotNull
    private boolean hasCurrentMedications;
    private String nameOfMedications;
  //  @NotNull
    private String familyIlnessHistory;
    private String accompanyingIlness;
   // @NotNull
    private boolean hasSurgicalProceduresInThePast;
    private String nameOfPatSurgicalProceduresAndDate;
    private String other;



    public MedicalRecordBindingModel() {
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


    public boolean isHasSmoke() {
        return hasSmoke;
    }

    public void setHasSmoke(boolean hasSmoke) {
        this.hasSmoke = hasSmoke;
    }

    public boolean isHasDrink() {
        return hasDrink;
    }

    public void setHasDrink(boolean hasDrink) {
        this.hasDrink = hasDrink;
    }

    public boolean isHasDiabetic() {
        return hasDiabetic;
    }

    public void setHasDiabetic(boolean hasDiabetic) {
        this.hasDiabetic = hasDiabetic;
    }

    public boolean isHasHighPressure() {
        return hasHighPressure;
    }

    public void setHasHighPressure(boolean hasHighPressure) {
        this.hasHighPressure = hasHighPressure;
    }

    public boolean isHasAllergies() {
        return hasAllergies;
    }

    public boolean isHasCurrentMedications() {
        return hasCurrentMedications;
    }

    public boolean isHasSurgicalProceduresInThePast() {
        return hasSurgicalProceduresInThePast;
    }

    public boolean getHasAllergies() {
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

    public boolean getHasCurrentMedications() {
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

    public boolean getHasSurgicalProceduresInThePast() {
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
