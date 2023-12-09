package com.example.hospitalmanagementsystem.web;

import com.example.hospitalmanagementsystem.models.bindingModels.MedicalRecordBindingModel;
import com.example.hospitalmanagementsystem.models.view.MedicalRecordViewModel;
import com.example.hospitalmanagementsystem.models.view.PatientViewModel;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import com.example.hospitalmanagementsystem.service.NurseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class MedicalRecordController {
    private final ModelMapper modelMapper;
    private final MedicalRecordService medicalRecordService;
    private final NurseService nurseService;

    public MedicalRecordController(ModelMapper modelMapper, MedicalRecordService medicalRecordService, NurseService nurseService) {
        this.modelMapper = modelMapper;
        this.medicalRecordService = medicalRecordService;
        this.nurseService = nurseService;
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

            return "redirect:/record/register"; // ето така! Посочваме пътя!!!!!

        }

        medicalRecordService.registerRecord(medicalRecordBindingModel);


        return "redirect:/";
        //todo redirect kum nurse profile
    }


    @GetMapping("/current-records")
    public String getMedicalRecord(Model model){
        List<MedicalRecordViewModel> records = medicalRecordService.getAllRecords();
        model.addAttribute("records", records);

        return "medical-record-view";

    }

    @GetMapping("/record/remove/{id}")
    String removePatient(@PathVariable Long id) {

        medicalRecordService.removeRecordById(id);

        return "redirect:/";

    }


    @ModelAttribute
    public MedicalRecordBindingModel medicalRecordBindingModel(){
        return new MedicalRecordBindingModel();
    }
}
