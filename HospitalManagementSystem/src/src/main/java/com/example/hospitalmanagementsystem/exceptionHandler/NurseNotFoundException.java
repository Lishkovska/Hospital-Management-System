package com.example.hospitalmanagementsystem.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nurse is not found!")
public class NurseNotFoundException extends RuntimeException{
    private final Long id;

    public NurseNotFoundException(Long id) {
        super("Nurse with id " + id + " not found!");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
