package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.covid.exception.VaccineException;
import com.covid.entities.Vaccine;
import com.covid.service.VaccineService;

@Controller
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/vaccines")
    public String listVaccines(Model model) {
        try {
            List<Vaccine> vacciness = vaccineService.getAllService();
            model.addAttribute("vaccines", vacciness);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "vaccineList";
    }

    @GetMapping("/vaccines/{vaccineId}")
    public String showVaccine(@PathVariable Integer vaccineId, Model model) {
        try {
            Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
            model.addAttribute("vaccine", vaccine);
        } catch (VaccineException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "vaccineDetails";
    }

    @GetMapping("/vaccines/new")
    public String createVaccineForm(Model model) {
        Vaccine vaccine = new Vaccine();
        model.addAttribute("vaccine", vaccine);
        return "createVaccine";
    }

    @PostMapping("/vaccines")
    public String createVaccine(@ModelAttribute("vaccine") Vaccine vaccine, Model model) throws VaccineException {
        // try {
            vaccineService.registerNewVaccine(vaccine);
        // } catch (VaccineException e) {
        //     model.addAttribute("error", e.getMessage());
        //     model.addAttribute("vaccine", vaccine);
        //     return "createVaccine";
        // }
        return "redirect:/vaccines";
    }


    @GetMapping("/vaccines/edit/{vaccineId}")
    public String editVaccinationCentre(@PathVariable Integer vaccineId, Model model) throws VaccineException{

        model.addAttribute("vaccine", vaccineService.getVaccineById(vaccineId));
   return "editVaccine";
    }



    // @GetMapping("/vaccines/edit/{vaccineId}")
    // public String editVaccineForm(@PathVariable Integer vaccineId, Model model) {
    //     try {
    //         Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
    //         model.addAttribute("vaccine", vaccine);
    //     } catch (VaccineException e) {
    //         model.addAttribute("error", e.getMessage());
    //     }
    //     return "vaccineForm";
    // }

    @PostMapping("/vaccines/{vaccineId}")
    public String updateVaccine(@PathVariable Integer vaccineId, @ModelAttribute Vaccine vaccine, Model model) throws VaccineException {
        
            Vaccine existingVaccine = vaccineService.getVaccineById(vaccineId);
            existingVaccine.setVaccineName(vaccine.getVaccineName());
            existingVaccine.setDescription(vaccine.getDescription());
          //  existingVaccine.setVaccineCount(vaccine.getVaccineCount());
         //   existingVaccine.setMember(vaccine.getMember());
            vaccineService.updateVaccine(existingVaccine);
       
        return "redirect:/vaccines";
    }

    // @GetMapping("/vaccines/{vaccineId}")
    // public String deleteVaccine(@PathVariable Integer vaccineId) throws VaccineException {
        
    //        // Vaccine vaccine = vaccineService.getVaccineById(vaccineId);
    //         vaccineService.deleteVaccine(vaccineId);
       
    //     return "redirect:/vaccines";
    // }

    
}