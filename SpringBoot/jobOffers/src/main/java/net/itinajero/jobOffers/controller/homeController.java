package net.itinajero.jobOffers.controller;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class homeController {

    @Autowired
    private IVacantsService serviceVacancies;

    //=======================================
    @GetMapping("/")
    public String displayHome(Model model){

        List<Vacancy> listVacancies = serviceVacancies.searchAllVacants();
        model.addAttribute("vacantsList",listVacancies);
        return "home";
    }

    @GetMapping("/listOffers")
    public String displayOffersList(Model model){
        List <String> jobList = new LinkedList<String>();
        jobList.add("job offer 1");
        jobList.add("job offer 2");
        jobList.add("job offer 3");
        jobList.add("job offer 4");

        model.addAttribute("jobList",jobList);
        return "jobOffers";
    }

    @GetMapping("/details/{id}")
    public String displayDetails(
            @PathVariable("id") int idVacant
            ,Model model){

        Vacancy vacancy = serviceVacancies.searchByID(idVacant);
        model.addAttribute("VacantObj",vacancy);

        return "detailsView";
    }


    @GetMapping("/displayTable")
    public String displayTable(Model model){
                                    // getVacancyObjects()
        List<Vacancy> vacancyList = serviceVacancies.searchAllVacants();
        model.addAttribute("vacancyList",vacancyList);
        return "displayVacancyTable";
    }

}
