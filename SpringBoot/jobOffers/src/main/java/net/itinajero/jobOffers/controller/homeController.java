package net.itinajero.jobOffers.controller;
import net.itinajero.jobOffers.Repository.RepositoryVacants;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Vacancy;
import net.itinajero.jobOffers.model.Vacantes;
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
import java.util.Optional;

@Controller
public class homeController {

    @Autowired
    private IVacantsService serviceVacancies;

    @Autowired
    private RepositoryVacants repositoryVacants;

    //=======================================
    @GetMapping("/")
    public String displayHome(Model model){
        List<Vacantes> listVacancies = repositoryVacants.findAll();
        model.addAttribute("vacantsList",listVacancies);

        return "home";
    }

    @GetMapping("/details/{id}")
    public String displayDetails(
            @PathVariable("id") int idVacant
            ,Model model){

        Optional optVacancy = repositoryVacants.findById(idVacant);
        if(optVacancy.isPresent()){
            Vacantes vacancy = (Vacantes) optVacancy.get();
            model.addAttribute("VacantObj",vacancy);
            return "detailsView";
        }else{
            return "home";
        }
    }

//    @GetMapping("/listOffers")
//    public String displayOffersList(Model model){
//        List <String> jobList = new LinkedList<String>();
//        jobList.add("job offer 1");
//        jobList.add("job offer 2");
//        jobList.add("job offer 3");
//        jobList.add("job offer 4");
//
//        model.addAttribute("jobList",jobList);
//        return "jobOffers";
//    }



//
//
    @GetMapping("/displayTable")
    public String displayTable(Model model){
        List<Vacantes> vacantesList = repositoryVacants.findAll();
        model.addAttribute("vacancyList",vacantesList);
        return "displayVacancyTable";
    }

}
