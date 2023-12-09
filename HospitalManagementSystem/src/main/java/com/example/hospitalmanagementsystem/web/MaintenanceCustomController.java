package com.example.hospitalmanagementsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaintenanceCustomController {
    @GetMapping("/maintenance")
    public String maintenanceGet() {
        return "maintenance-custom-interseptor";
    }
}
