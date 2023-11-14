package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.service.NurseService;
import com.example.hospitalmanagementsystem.service.PatientService;
import com.example.hospitalmanagementsystem.service.WardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class HomeController {
    private final WardService wardService;
    private final NurseService nurseService;
    private final PatientService patientService;

    public HomeController(WardService wardService, NurseService nurseService,
                          PatientService patientService) {
        this.wardService = wardService;
        this.nurseService = nurseService;
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }




   /* @GetMapping("nurses/test")
    public String testConfirm(Model model){
        model.addAttribute("wards", wardService.findAllPatientsAndCount() );

        return "home-test";
    } */
}
