package net.itinajero.jobOffers.controller;

import java.io.File;

import net.itinajero.jobOffers.Service.ICategoriasService;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.model.Categoria;
import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.Utils;

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

    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;
    //application.properties: spring.servlet.multipart.location=${java.io.tmpdir}/myapp-uploads

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCreateVacant(
            Vacancy vacant,
            BindingResult result,
            Model model,
            RedirectAttributes attributes,
            @RequestParam("archivoImagen") MultipartFile multiPart
    ) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("An error has happened: " + error.getDefaultMessage());
            }
            return "vacants/formVacante";
        }

        // ✅ Upload image to system temp dir
        if (!multiPart.isEmpty()) {
            String imageName = Utils.saveFile(multiPart, uploadDir + File.separator);
            if (imageName != null) {
                vacant.setImage(imageName);
            }
        }

        // Link category
        Integer categoriaId = vacant.getCategoria().getId();
        Categoria fullCategoria = serviceCategories.buscarPorId(categoriaId);
        vacant.setCategoria(fullCategoria);

        // Save vacancy
        serviceVacancies.save(vacant);
        System.out.println(vacant.toString());
        System.out.println(vacant.getCategoria().toString());

        // Flash message and redirect
        attributes.addFlashAttribute("msg", "New Category Saved");
        return "redirect:/vacancies/index";
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

