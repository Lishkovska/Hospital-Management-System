package com.example.hospitalmanagementsystem.exceptionHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PatientNotFoundExceptionTest {
    @Test
    public void testPatientNotFoundException() {

        Long patientId = 4L;


        PatientNotFoundException exception = assertThrows(PatientNotFoundException.class, () -> {
            throw new PatientNotFoundException(patientId);
        });


        assertEquals("Patient with id 4 not found!", exception.getMessage());
        assertEquals(patientId, exception.getId());
    }

}