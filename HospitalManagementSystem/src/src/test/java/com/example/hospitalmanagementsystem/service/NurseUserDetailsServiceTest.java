package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.repository.NurseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NurseUserDetailsServiceTest {
    private NurseUserDetailService nurseUserDetailsToTest;
    private final String USERNAME_NOT_EXIST = "test";

    @Mock
    private NurseRepository mockNurseRepository;

    @BeforeEach
    void setUp() {
        nurseUserDetailsToTest = new NurseUserDetailService(
              mockNurseRepository
        );
    }

    @Test
    void testNurseExist(){

        String EXISTING_USERNAME_NURSE = "Sisito";
        NurseEntity testNurse = new NurseEntity();
               testNurse.setPassword("12345");
               testNurse.setUsername(EXISTING_USERNAME_NURSE);
               testNurse.setAge(33);
               testNurse.setEducation("master");



        when(mockNurseRepository.findByUsername(EXISTING_USERNAME_NURSE)).
                thenReturn(Optional.of(testNurse));

        UserDetails nurseDetails =
                nurseUserDetailsToTest.loadUserByUsername(EXISTING_USERNAME_NURSE);


        Assertions.assertNotNull(nurseDetails);
        Assertions.assertEquals(EXISTING_USERNAME_NURSE, nurseDetails.getUsername());
        Assertions.assertEquals(testNurse.getPassword(), nurseDetails.getPassword());

    }

    @Test
    void testNurseNotExist(){
        assertThrows(
                UsernameNotFoundException.class,
                () -> nurseUserDetailsToTest.loadUserByUsername(USERNAME_NOT_EXIST)
        );
    }
}
