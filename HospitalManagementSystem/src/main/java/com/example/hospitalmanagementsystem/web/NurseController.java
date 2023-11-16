package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.bindingModels.NurseRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.models.view.NurseProfileViewModel;
import com.example.hospitalmanagementsystem.service.NurseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/nurses")
public class NurseController {
    private final NurseService nurseService;
    private final ModelMapper modelMapper;

    public NurseController(NurseService nurseService, ModelMapper modelMapper) {
        this.nurseService = nurseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid NurseRegisterBindingModel nurseRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !nurseRegisterBindingModel
                .getPassword().equals(nurseRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes
                    .addFlashAttribute("nurseRegisterBindingModel", nurseRegisterBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.nurseRegisterBindingModel",
                            bindingResult);

            return "redirect:auth-register";
        }

        boolean isUsernameExists = nurseService
                .findByUsername(nurseRegisterBindingModel.getUsername());

        if (isUsernameExists) {

            return "redirect:auth-register";
        }

        nurseService.registerNurse(modelMapper.map(nurseRegisterBindingModel, NurseServiceModel.class));

       // return "redirect:auth-register";
       return "redirect:auth-login" ;
    }

   @GetMapping("/profile")
    public String getProfile(Principal principal, Model model){
        String username = principal.getName();
        NurseEntity nurse = nurseService.getNurse(username);

        NurseProfileViewModel nurseProfileViewModel = new NurseProfileViewModel(
                username,
                nurse.getLastName(),
                nurse.getWard().getName().name(),
                nurse.getPatientList()
        );

        model.addAttribute("nurse", nurseProfileViewModel);
        return "profile";

    }

   /* @GetMapping("/profile/{id}")
    public String viewNurseProfileById(@PathVariable("id") Long id,
                                      Model model) {

        NurseServiceModel nurseProfileViewModel = nurseService.findById(id);

        model.addAttribute("nurseProfile", nurseProfileViewModel);

        return "profile-all-nurses";
    }*/



    @ModelAttribute
    public NurseRegisterBindingModel nurseRegisterBindingModel() {
        return new NurseRegisterBindingModel();
    }

    }



