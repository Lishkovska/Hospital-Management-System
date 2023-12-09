package com.example.hospitalmanagementsystem.models.view;

public class MedicalRecordViewModel {
    private Long id;
    private String patientEgn;
    private String mainDiagnosis;
    private String pastConditions;
    private boolean hasSmoke;
    private boolean hasDrink;
    private boolean hasDiabetic;
    private boolean hasHighPressure;
    private boolean hasAllergies;
    private String nameOfAllergies;
    private boolean hasCurrentMedications;
    private String nameOfMedications;
    private String familyIlnessHistory;
    private String accompanyingIlness;
    private boolean hasSurgicalProceduresInThePast;
    private String nameOfPatSurgicalProceduresAndDate;
    private String other;

    public MedicalRecordViewModel(Long id, String patientEgn, String mainDiagnosis,
                                  String pastConditions, boolean hasSmoke, boolean hasDrink,
                                  boolean hasDiabetic, boolean hasHighPressure, boolean hasAllergies,
                                  String nameOfAllergies, boolean hasCurrentMedications, String nameOfMedications, String familyIlnessHistory, String accompanyingIlness,
                                  boolean hasSurgicalProceduresInThePast,
                                  String nameOfPatSurgicalProceduresAndDate, String other) {
        this.id = id;
        this.patientEgn = patientEgn;
        this.mainDiagnosis = mainDiagnosis;
        this.pastConditions = pastConditions;
        this.hasSmoke = hasSmoke;
        this.hasDrink = hasDrink;
        this.hasDiabetic = hasDiabetic;
        this.hasHighPressure = hasHighPressure;
        this.hasAllergies = hasAllergies;
        this.nameOfAllergies = nameOfAllergies;
        this.hasCurrentMedications = hasCurrentMedications;
        this.nameOfMedications = nameOfMedications;
        this.familyIlnessHistory = familyIlnessHistory;
        this.accompanyingIlness = accompanyingIlness;
        this.hasSurgicalProceduresInThePast = hasSurgicalProceduresInThePast;
        this.nameOfPatSurgicalProceduresAndDate = nameOfPatSurgicalProceduresAndDate;
        this.other = other;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
