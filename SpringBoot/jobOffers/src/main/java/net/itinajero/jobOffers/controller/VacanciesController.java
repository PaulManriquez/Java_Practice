package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Service.ICategoriasService;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Categoria;
import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacancies")
public class VacanciesController {

    @Autowired
    private IVacantsService serviceVacancies;

    @Autowired
    private ICategoriasService serviceCategories;

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
    public String create(Vacancy vacancy,
                         Model model){

        // to the vacancy we add a new category by an category object
        List<Categoria> categoryList = serviceCategories.buscarTodas();
        model.addAttribute("listCategories",categoryList);
        System.out.println(categoryList);
        return "vacants/formVacante";
    }

    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public String saveCreateVacant(
            Vacancy vacant, /* <-- the attributes are filled automatically from the form*/
            BindingResult result,
            Model model,
            RedirectAttributes attributes
    ){
        // Handling Error when for example in the field of salary ofered, an no number char has been introduced
        if (result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("An error has happened: " + error.getDefaultMessage());
            }
            return "vacants/formVacante";
        }
        // <-------------------------------

        //Get the ID from the Form, and, set the Categoria object to the vacant
        Integer categoriaId = vacant.getCategoria().getId(); //Get the category ID of the vacant, according with the passed in the form
        Categoria fullCategoria = serviceCategories.buscarPorId(categoriaId); // search the id category by ID
        vacant.setCategoria(fullCategoria); // assign to the vacant the according object , is set to the vacant

        //save and print the new vacant
        serviceVacancies.save(vacant);
        System.out.println(vacant.toString() );
        System.out.println(vacant.getCategoria().toString());

        //Sent to the model the new list of vacants
        List<Vacancy> myListOfVacants = serviceVacancies.searchAllVacants();
        model.addAttribute("vacantsList",myListOfVacants);


        // <- Since we use a redirect in the return and redirect is a GET request
        // and here this controller is a POST request, the attribute do not exist in the
        // new GET request
//        model.addAttribute("msg","New Register Saved");
// <-------------------------------------------------------------------------------------

        //Redirect and Flash attributes
        attributes.addFlashAttribute("msg", "New Category Saved");

        return "redirect:/vacancies/index";
        //return "vacants/listVacantes";
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

