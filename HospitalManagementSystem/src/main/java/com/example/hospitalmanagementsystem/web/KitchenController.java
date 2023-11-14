package com.example.hospitalmanagementsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KitchenController {
    @GetMapping("/kitchen/menu")
    public String register(){
        return "all-menus";
    }

    @GetMapping("/normal-diet")
    public String normalMenu(){
        return "normal-diet";
    }

    @GetMapping("/pevzner")
    public String pevzner(){
        return "pevzner";
    }

    @GetMapping("/milk-gluten-puree")
    public String specificDiet(){
        return "milk-gluten-puree";
    }
}
