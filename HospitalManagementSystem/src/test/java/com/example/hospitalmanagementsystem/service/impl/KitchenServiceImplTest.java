package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;
import com.example.hospitalmanagementsystem.models.entity.Ward;
import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;
import com.example.hospitalmanagementsystem.models.enums.WardEnum;
import com.example.hospitalmanagementsystem.repository.KitchenRepository;
import com.example.hospitalmanagementsystem.repository.WardRepository;
import com.example.hospitalmanagementsystem.service.KitchenService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KitchenServiceImplTest {
    private KitchenService kitchenServiceToTest;
    private final TypeOfMenu TYPE_OF_MENU = TypeOfMenu.healthy;

    @Mock
    private KitchenRepository kitchenRepositoryMock;

    @BeforeEach
    void setUp() {
        kitchenServiceToTest = new KitchenServiceImpl(
                kitchenRepositoryMock
        );
    }

    @Test
    void testIfExistfindByTypeOfMenu() {
        TypeOfMenu typeOfMenuExist = TypeOfMenu.healthy;
        KitchenCatering kitchenCateringTest = new KitchenCatering();
        kitchenCateringTest.setTypeOfMenu(typeOfMenuExist);

        when(kitchenRepositoryMock.findByTypeOfMenu(typeOfMenuExist)).
                thenReturn(Optional.of(kitchenCateringTest));

        kitchenServiceToTest.findByTypeOfMenu(TYPE_OF_MENU);

        Assertions.assertEquals(typeOfMenuExist, kitchenCateringTest.getTypeOfMenu());


    }
}