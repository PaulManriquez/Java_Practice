package net.itinajero.jobOffers.controller;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

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

//        model.addAttribute("message","welcome to job offers");
//        model.addAttribute("currentDate",new Date());

        String jobName = "A job name1";
        Date datePublished = new Date();
        double salary = 900.22;
        boolean current = true;

        model.addAttribute("jobName",jobName);
        model.addAttribute("datePublished",datePublished);
        model.addAttribute("salary",salary);
        model.addAttribute("current",current);

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

    @GetMapping("/details")
    public String displayDetails(Model model){
        Vacancy vacancy = new Vacancy();

        vacancy.setName("A vacancy name ");
        vacancy.setDate(new Date());
        vacancy.setDescription("This is a description of the vacancy");
        vacancy.setSalary(22.22);
        //Passing the class to call its attributes in the view side
        model.addAttribute("vacancy",vacancy);
        return "detailsView";
    }

//    //Private method: return a list of objects
//    private List<Vacancy> getVacancyObjects(){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        List<Vacancy> listVacancies = new LinkedList<Vacancy>();
//
//        try{
//            //Job offer 1
//            Vacancy vacancy1 = new Vacancy();
//            vacancy1.setId(1);
//            vacancy1.setName("Vacancy 1");
//            vacancy1.setDescription("Description 1");
//            vacancy1.setDate(sdf.parse("08-02-2025"));
//            vacancy1.setSalary(22.01);
//            vacancy1.setExcels(1);
//            vacancy1.setImage("jobIcon.png");
//
//            //Job offer 2
//            Vacancy vacancy2 = new Vacancy();
//            vacancy2.setId(2);
//            vacancy2.setName("Vacancy 2");
//            vacancy2.setDescription("Description 2");
//            vacancy2.setDate(sdf.parse("08-02-2025"));
//            vacancy2.setSalary(22.02);
//            vacancy2.setExcels(0);
//            vacancy2.setImage("jobIcon2.png");
//
//            //Job offer 3
//            Vacancy vacancy3 = new Vacancy();
//            vacancy3.setId(3);
//            vacancy3.setName("Vacancy 3");
//            vacancy3.setDescription("Description 3");
//            vacancy3.setDate(sdf.parse("08-02-2025"));
//            vacancy3.setSalary(22.03);
//            vacancy3.setExcels(1);
//            vacancy3.setImage("jobIcon.png");
//
//            //
//            listVacancies.add(vacancy1);
//            listVacancies.add(vacancy2);
//            listVacancies.add(vacancy3);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        return listVacancies;
//    }

    @GetMapping("/displayTable")
    public String displayTable(Model model){
                                    // getVacancyObjects()
        List<Vacancy> vacancyList = serviceVacancies.searchAllVacants();
        model.addAttribute("vacancyList",vacancyList);
        return "displayVacancyTable";
    }

}
