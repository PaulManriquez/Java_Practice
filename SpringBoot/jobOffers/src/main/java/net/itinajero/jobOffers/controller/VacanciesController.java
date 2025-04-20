package net.itinajero.jobOffers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacancies")
public class VacanciesController {

    @GetMapping("/delete")//?id=3
    public String deleteVacant(@RequestParam("id") int idVacant, Model model){
        System.out.println("Deleting the vacant: "+ idVacant);
        model.addAttribute("idVacant",idVacant);
        return "vacants/deleteVacantMessage";
    }

    @GetMapping("/view/{id}")
    public String seeDetails(@PathVariable("id") int idVacant , Model model){
        System.out.println("id_Vacant" + idVacant);
        model.addAttribute("idVacant",idVacant);
        return "vacants/details";
    }
}

