package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/createFormVacant")
    public String create(){
        return "vacants/formVacante";
    }

    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public String saveCreateVacant(
            Vacancy vacant
    ){
        serviceVacancies.save(vacant);
        System.out.println(vacant.toString());
        return "vacants/ListOfVacants";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }

    @GetMapping("/index")
    public String displayIndex(Model model){
        List<Vacancy> myListOfVacants = serviceVacancies.searchAllVacants();
        for(Vacancy ptr : myListOfVacants){
            System.out.println(ptr.getName());
        }
        model.addAttribute("vacantsList",myListOfVacants);

        return "vacants/listVacantes";
    }

//    @PostMapping("/saveCV")
//    @RequestMapping(value = "/save",method=RequestMethod.POST)
//    public String saveCreateVacant(
//            @RequestParam("Name") String NameF, @RequestParam("Description") String DescriptionF,
//            @RequestParam("Estatus") String EstatusF, @RequestParam("Date") String DateF,
//            @RequestParam("Excelled") int ExcelledF, @RequestParam("Salary") double Salary,
//            @RequestParam("Details") String Details
//
//    ){
//        System.out.println(NameF + " " + EstatusF + " " + DescriptionF +
//                " " + DateF + " " + ExcelledF + " " + Salary + " " + Details);
//        return "vacants/ListOfVacants";
//    }
}

