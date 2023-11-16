package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.bindingModels.PatientRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.service.PatientServiceModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.service.PatientService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;
    private final ModelMapper modelMapper;

    public PatientController(PatientService patientService, ModelMapper modelMapper) {
        this.patientService = patientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(){
        return "register-patient";
    }

    @PostMapping("/register")
    public String registerPost(@Valid PatientRegisterBindingModel patientRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("patientRegisterBindingModel",patientRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.patientRegisterBindingModel",
                    bindingResult);

            return "redirect:register";
        }
        patientService.registerPatient(modelMapper.map(patientRegisterBindingModel, PatientServiceModel.class));
        return "/index";

    }


//todo
    @GetMapping("/remove/{id}")
    String removePatient(@PathVariable Long id) {

        patientService.removePatientById(id);

        return "redirect:/";
    }

    @ModelAttribute
    public PatientRegisterBindingModel patientRegisterBindingModel(){
        return new PatientRegisterBindingModel();
    }
}
