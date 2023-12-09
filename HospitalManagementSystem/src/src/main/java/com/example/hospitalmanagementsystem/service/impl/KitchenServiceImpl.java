package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.models.entity.KitchenCatering;
import com.example.hospitalmanagementsystem.models.enums.TypeOfMenu;
import com.example.hospitalmanagementsystem.service.KitchenService;
import com.example.hospitalmanagementsystem.repository.KitchenRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class KitchenServiceImpl implements KitchenService {
  private final KitchenRepository kitchenRepository;

    public KitchenServiceImpl(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    @Override
    public void initTypeOfMenu() {
        if(kitchenRepository.count() != 0){
            return;
        }
        Arrays.stream(TypeOfMenu.values())
                .forEach(type -> {
                    KitchenCatering kitchenCatering = new KitchenCatering();
                    kitchenCatering.setTypeOfMenu(type);
                    kitchenCatering.setDietNumber(kitchenCatering.getDietNumber());
                    switch (type){
                        case puree -> kitchenCatering.setTypeOfMenu(TypeOfMenu.puree);
                        case normal -> kitchenCatering.setTypeOfMenu(TypeOfMenu.normal);
                        case healthy -> kitchenCatering.setTypeOfMenu(TypeOfMenu.healthy);
                        case diaryFree -> kitchenCatering.setTypeOfMenu(TypeOfMenu.diaryFree);
                        case glutenFree -> kitchenCatering.setTypeOfMenu(TypeOfMenu.glutenFree);
                        case PevznerDiet -> kitchenCatering.setTypeOfMenu(TypeOfMenu.PevznerDiet);
                        case lowPotassium -> kitchenCatering.setTypeOfMenu(TypeOfMenu.lowPotassium);
                    }
                    kitchenRepository.save(kitchenCatering);
                });
    }



    @Override
    public KitchenCatering findByTypeOfMenu(TypeOfMenu menu) {
        return kitchenRepository.findByTypeOfMenu(menu)
                .orElse(null);
    }
}

