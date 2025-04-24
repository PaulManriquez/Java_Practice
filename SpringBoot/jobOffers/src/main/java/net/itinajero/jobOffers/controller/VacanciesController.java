package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacancies")
public class VacanciesController {
    @Autowired
    private IVacantsService serviceVacancies;

    //====
    @GetMapping("/delete")//?id=3
    public String deleteVacant(
            @RequestParam("id") int idVacant,
            Model model){
        System.out.println("Deleting the vacant: "+ idVacant);
        model.addAttribute("idVacant",idVacant);
        return "vacants/deleteVacantMessage";
    }

    @GetMapping("/view/{id}")
    public String seeDetails(
            @PathVariable("id") int idVacant ,
            Model model){

        Vacancy vacancy = serviceVacancies.searchByID(idVacant);

        System.out.println("id_Vacant" + idVacant);
//        model.addAttribute("idVacant",idVacant);
        model.addAttribute("idVacant",vacancy);
        return "vacants/details";
    }
}

