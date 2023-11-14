package com.example.hospitalmanagementsystem.models.entity;

import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "wards")
public class Ward extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WardEnum name;
    @Column(nullable = false)
    private Integer bedCapacity;
    @Column(nullable = false)
    private Integer roomCapacity;

    @OneToMany(mappedBy = "ward")
    private List<NurseEntity> nurses;
    @OneToMany(mappedBy = "ward")
    private List<Patient> patientList;

    public Ward() {
    }

    public WardEnum getName() {
        return name;
    }

    public void setName(WardEnum name) {
        this.name = name;
    }


    public Integer getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(Integer bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public List<NurseEntity> getNurses() {
        return nurses;
    }

    public void setUsers(List<NurseEntity> users) {
        this.nurses = nurses;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
