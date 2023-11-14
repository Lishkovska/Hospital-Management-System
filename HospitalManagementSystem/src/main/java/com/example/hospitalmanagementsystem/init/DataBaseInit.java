package com.example.hospitalmanagementsystem.init;

import com.example.hospitalmanagementsystem.service.KitchenService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {
   private final KitchenService kitchenService;
   private final WardService wardService;


   public DataBaseInit(KitchenService kitchenService, WardService wardService) {

       this.kitchenService = kitchenService;

       this.wardService = wardService;
   }

    @Override
    public void run(String... args) throws Exception {

     kitchenService.initTypeOfMenu();
       wardService.initWardName();

    }
}
