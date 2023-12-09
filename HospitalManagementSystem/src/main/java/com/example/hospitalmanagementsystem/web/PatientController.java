package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.exceptionHandler.NurseNotFoundException;
import com.example.hospitalmanagementsystem.exceptionHandler.PatientNotFoundException;
import com.example.hospitalmanagementsystem.models.bindingModels.PatientRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.Patient;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.service.PatientService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
                               RedirectAttributes redirectAttributes,
                               @AuthenticationPrincipal UserDetails userDetails){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("patientRegisterBindingModel",patientRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.patientRegisterBindingModel",
                    bindingResult);

            return "redirect:/patient/register";
        }
     //   patientService.registerPatient(modelMapper.map(patientRegisterBindingModel, PatientServiceModel.class), userDetails);
        patientService.registerPatient(patientRegisterBindingModel, userDetails);
        return "redirect:/record/register";

    }

    @GetMapping("/all")
    public String getAllPatients(Model model) {
        List<PatientViewModel> patients= patientService.getAllPatients();

        model.addAttribute("patients", patients);

        return "patient-view-model";
    }

    @GetMapping("/{id}")
    public Long getPatientById(@PathVariable("id") Long id){
        throw new PatientNotFoundException(id);

    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ModelAndView notFoundNurse(PatientNotFoundException patientNotFoundException){
        ModelAndView modelAndView = new ModelAndView("patient-not-found");
        modelAndView.addObject("id", patientNotFoundException.getId());

        return modelAndView;

    }



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
