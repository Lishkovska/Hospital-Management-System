package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import com.example.hospitalmanagementsystem.repository.WardRepository;
import com.example.hospitalmanagementsystem.service.NurseUserDetailService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WardServiceImplTest {
private WardService wardServiceToTest;
private final WardEnum WARD_ENUM = WardEnum.Cardiology;


@Mock
private  WardRepository wardRepositoryMock;

@BeforeEach
void setUp() {
    wardServiceToTest = new WardServiceImpl(
            wardRepositoryMock
    );
}

@Test
void testExistWardName() {
    WardEnum wardEnumExist = WardEnum.Cardiology;
    Ward wardTest = new Ward();
    wardTest.setName(wardEnumExist);

    when(wardRepositoryMock.findByName(wardEnumExist)).
            thenReturn(Optional.of(wardTest));

    wardServiceToTest.findByWardNameEnum(WARD_ENUM);

    Assertions.assertEquals(wardEnumExist, wardTest.getName());


    }



}