package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;

public interface KitchenService {
    void initTypeOfMenu();

    KitchenCatering findByNameMenuEnum(KitchenCatering menu);
}
