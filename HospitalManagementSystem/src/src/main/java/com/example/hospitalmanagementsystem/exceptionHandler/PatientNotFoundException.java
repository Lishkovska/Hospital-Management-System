package com.example.hospitalmanagementsystem.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Patient is not found!")
public class PatientNotFoundException extends RuntimeException{
    private final Long id;

    public PatientNotFoundException(Long id) {
        super("Nurse with id " + id + " not found!");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

