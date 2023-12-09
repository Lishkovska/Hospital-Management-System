package com.example.hospitalmanagementsystem.exceptionHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class NurseNotFoundExceptionTest {
    @Test
    public void testNurseNotFoundException() {

        Long nurseId = 12L;

        NurseNotFoundException exception = assertThrows(NurseNotFoundException.class, () -> {
            throw new NurseNotFoundException(nurseId);
        });

        assertEquals("Nurse with id 12 not found!", exception.getMessage());
        assertEquals(nurseId, exception.getId());
    }
}

