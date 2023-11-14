package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.bindingModels.NurseRegisterBindingModel;
import com.example.hospitalmanagementsystem.models.service.MedicalRecordServiceModel;
import com.example.hospitalmanagementsystem.models.service.NurseServiceModel;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalRecordController {
    private final ModelMapper modelMapper;
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(ModelMapper modelMapper, MedicalRecordService medicalRecordService) {
        this.modelMapper = modelMapper;
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/record/register")
    public String registerRecord(){
        return "register-medical-record";
    }

    @PostMapping("/record/register")
    public String registerConfirm(@Valid MedicalRecordBindingModel medicalRecordBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ) {

            redirectAttributes
                    .addFlashAttribute("medicalRecordBindingModel", medicalRecordBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.medicalRecordBindingModel",
                            bindingResult);

            return "redirect:record/register";
            // ili e bez /?
        }

        medicalRecordService.registerRecord(modelMapper.map(medicalRecordBindingModel, MedicalRecordServiceModel.class));

        return "redirect:index";
        //todo redirect kum nurse profile
    }


    @ModelAttribute
    public MedicalRecordBindingModel medicalRecordBindingModel(){
        return new MedicalRecordBindingModel();
    }
}
