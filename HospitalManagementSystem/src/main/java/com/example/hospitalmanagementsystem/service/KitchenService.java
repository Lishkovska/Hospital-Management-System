package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;
import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;

public interface KitchenService {
    void initTypeOfMenu();

    //KitchenCatering findByNameMenuEnum(KitchenCatering menu);
    KitchenCatering findByTypeOfMenu(TypeOfMenu menu);
}
