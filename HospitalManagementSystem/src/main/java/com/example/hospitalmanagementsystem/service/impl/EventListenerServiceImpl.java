package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.event.NurseCreateEvent;
import com.example.hospitalmanagementsystem.service.NurseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventListenerServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(NurseService.class);

    @EventListener(NurseCreateEvent.class)
    public void onNurseCreated(NurseCreateEvent nurseCreateEvent) {
        LOGGER.info("Information for registered nurses {} ", nurseCreateEvent.getAllNursesIDs());
    }
}
