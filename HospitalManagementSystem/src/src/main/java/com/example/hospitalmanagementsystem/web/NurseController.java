package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.event.NurseCreateEvent;
import com.example.hospitalmanagementsystem.exceptionHandler.NurseNotFoundException;
import com.example.hospitalmanagementsystem.models.bindingModels.NurseRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.entity.NurseEntity;
import com.example.hospitalmanagementsystem.models.view.NurseProfileViewModel;
import com.example.hospitalmanagementsystem.service.NurseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import org.slf4j.Logger;

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

            return "redirect:/nurses/register";
        }

        boolean isUsernameExists = nurseService
                .findByUsername(nurseRegisterBindingModel.getUsername());

        if (isUsernameExists) {

            return "redirect:/nurses/register";
        }


       nurseService.registerNurse(nurseRegisterBindingModel);

       return "redirect:auth-login" ;

    }

   @GetMapping("/profile")
    public String getProfile(Principal principal, Model model){
        String username = principal.getName();
        NurseEntity nurse = nurseService.getNurse(username);
       int size = nurse.getPatientList().size();

       NurseProfileViewModel nurseProfileViewModel = new NurseProfileViewModel(
                username,
                nurse.getLastName(),
                nurse.getWard().getName().name(),
               nurse.getPatientList()
        );

        model.addAttribute("nurse", nurseProfileViewModel);
        return "profile";

    }

  @GetMapping("/nurses/{id}")
  public String getNurseById(@PathVariable("id") Long id){
        throw new NurseNotFoundException(id);

  }

  @ExceptionHandler(NurseNotFoundException.class)
  public ModelAndView notFoundNurse(NurseNotFoundException nurseNotFoundException){
  ModelAndView modelAndView = new ModelAndView("nurse-not-found");
  modelAndView.addObject("id", nurseNotFoundException.getId());

  return modelAndView;

    }


    @ModelAttribute
    public NurseRegisterBindingModel nurseRegisterBindingModel() {
        return new NurseRegisterBindingModel();
    }

    }



