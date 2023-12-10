package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.repository.NurseRepository;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.repository.UserRoleRepository;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class NurseServiceImplTest {
    @Mock
    private  NurseRepository nurseRepositoryMock;
    @Mock
    private  PasswordEncoder passwordEncoderMock;
    @Mock
    private  ModelMapper modelMapperMock;
    @Mock
    private WardService wardServiceMock;
    @Mock
    private  PatientRepository patientRepositoryMock;
    @Mock
    private UserRoleRepository userRoleRepositoryMock;
    @Mock
    private ApplicationEventPublisher appEventPublisherMock;

    private NurseService nurseServiceToTest;
    private final String existingUsername = "Sisito";
    private final String notExistingUsername = "test";

    @BeforeEach
    void setUp() {
        nurseServiceToTest  = new NurseServiceImpl(
                nurseRepositoryMock,passwordEncoderMock, modelMapperMock, wardServiceMock, patientRepositoryMock,
                userRoleRepositoryMock, appEventPublisherMock)
        ;
    }

    @Test
    public void testSave() {
    NurseEntity nurseEntity = new NurseEntity();
    nurseEntity.setUsername("test");

    nurseServiceToTest.save(nurseEntity);
    Mockito.verify(nurseRepositoryMock, Mockito.times(1)).saveAndFlush(nurseEntity);
}

    @Test
    public void testFindByUsernameWhenUsernameExists() {

        Mockito.when(nurseRepositoryMock.findByUsername(existingUsername))
                .thenReturn(Optional.of(new NurseEntity()));

        boolean result = nurseServiceToTest.findByUsername(existingUsername);

        assertTrue(result);
    }

    @Test
    public void testFindByUsernameWhenUsernameDoesNotExist() {

        Mockito.when(nurseRepositoryMock.findByUsername(notExistingUsername))
                .thenReturn(Optional.empty());

        boolean result = nurseServiceToTest.findByUsername(notExistingUsername);

        assertFalse(result);
    }

    @Test
    public void testGetNurseWhenNurseExists() {

        NurseEntity mockNurseEntity = new NurseEntity();
        Mockito.when(nurseRepositoryMock.findByUsername(existingUsername))
                .thenReturn(Optional.of(mockNurseEntity));

        NurseEntity nurse = nurseServiceToTest.getNurse(existingUsername);

        assertEquals(mockNurseEntity, nurse);
    }

    @Test
    public void testGetNurseWhenNurseDoesNotExist() {

        Mockito.when(nurseRepositoryMock.findByUsername(notExistingUsername))
                .thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () ->
                nurseServiceToTest.getNurse(notExistingUsername));
    }


}