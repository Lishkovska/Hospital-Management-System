package com.example.hospitalmanagementsystem.event;

import com.example.hospitalmanagementsystem.models.bindingModels.NurseRegisterBindingModel;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

public class NurseCreateEvent extends ApplicationEvent {
    private List<Long> allNursesIDs = new ArrayList<>();

    public NurseCreateEvent(Object source) {
        super(source);
    }

    public List<Long> getAllNursesIDs() {
        return allNursesIDs;
    }

    public void setAllNursesIDs(List<Long> allNursesIDs) {
        this.allNursesIDs = allNursesIDs;
    }

    public NurseCreateEvent addNurseId(Long nurseId) {
        this.allNursesIDs.add(nurseId);
        return this;
    }
}
