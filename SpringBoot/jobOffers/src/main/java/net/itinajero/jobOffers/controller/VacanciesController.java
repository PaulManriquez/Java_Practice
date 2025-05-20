package net.itinajero.jobOffers.controller;

import java.io.File;

import jakarta.transaction.Transactional;
import net.itinajero.jobOffers.Repository.RepositoryCategorias;
import net.itinajero.jobOffers.Repository.RepositoryVacants;
import net.itinajero.jobOffers.Service.ICategoriasService;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.Servicee.VacantesService;
import net.itinajero.jobOffers.model.Categoria;
import net.itinajero.jobOffers.model.Categorias;
import net.itinajero.jobOffers.model.Vacancy;
import net.itinajero.jobOffers.model.Vacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import java.util.Optional;

@Controller
@RequestMapping("/vacancies")
public class VacanciesController {

    @Autowired
    private IVacantsService serviceVacancies;

    @Autowired
    private ICategoriasService serviceCategories;

    @Autowired
    private RepositoryVacants repositoryVacants;

    @Autowired
    private RepositoryCategorias repositoryCategorias;

    @Autowired
    private VacantesService vacantesService;


    @PostMapping("/edit")
    public String editVacante(
            @RequestParam("id") int idVacante,
            Model model
    ){
//        System.out.println("======> ID("+idVacante + ")");


        Optional optVac = repositoryVacants.findById(idVacante);
        if(optVac.isPresent()){
            Vacantes vacObj = (Vacantes) optVac.get();
            model.addAttribute("vacancy",vacObj);
            List<Categorias> listCategories = repositoryCategorias.findAll();
            model.addAttribute("listCategories",listCategories);

            return "vacants/formVacante";
        }
        return "redirect:/vacancies/index";
    }

    @PostMapping("/delete")
    public String deleteVacant(
            @RequestParam("id") int idVacant,
            RedirectAttributes redirectAttributes) {

        Optional vacantToDelete = repositoryVacants.findById(idVacant);
        if(vacantToDelete.isPresent()){
            vacantesService.deleteVacante(idVacant);
            // Add a success message to be shown after deletion
            redirectAttributes.addFlashAttribute("msg", "Vacante eliminada con éxito.");
        }else{
            // Add a success message to be shown after deletion
            redirectAttributes.addFlashAttribute("msg", "Error al eliminar la vacante");
        }

        // Redirect to the list of vacancies after deletion
        return "redirect:/vacancies/index";
    }


//    @GetMapping("/view/{id}")
//    public String seeDetails(
//            @PathVariable("id") int idVacant ,
//            Model model){
//
//        Vacancy vacancy = serviceVacancies.searchByID(idVacant);
//
//        System.out.println("id_Vacant" + idVacant);
////        model.addAttribute("idVacant",idVacant);
//        model.addAttribute("idVacant",vacancy);
//        return "vacants/details";
//    }

    @GetMapping("/createFormVacant")
    public String create(Vacantes vacancy,
                         Model model){

        List<Categorias> listCategories = repositoryCategorias.findAll();
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("vacancy",vacancy);

        return "vacants/formVacante";
    }

    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;
    //application.properties: spring.servlet.multipart.location=${java.io.tmpdir}/myapp-uploads


    //Note: if an id alredy exist/ispassed to the model
    //This will be updated, and will not create another insert/object in the data base
    //Tip to do: mark as a hidden the data you want to conserve
    //<input type="hidden" th:field="*{id}">
    //<input type="hidden" th:field="*{imagen}">
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public String saveCreateVacant(
            Vacantes vacant,// Objects properties automatically linked/saved
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
                vacant.setImagen(imageName);
            }
        }

        // Link category
        Integer categoriaId = vacant.getCategoria().getId();
        System.out.println("====>"+categoriaId);
        Optional fullCategoria = repositoryCategorias.findById(categoriaId);

        if(fullCategoria.isPresent()){
            Categorias categoria = (Categorias) fullCategoria.get();
            vacant.setCategoria(categoria);
        }


        // Save vacant
        repositoryVacants.save(vacant);


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

        List<Vacantes> listVacantes = repositoryVacants.findAll();
        model.addAttribute("vacantsList",listVacantes);

        return "vacants/listVacantes";
    }

    @GetMapping(value="/indexPaginate")
    public String displayIndexPaginated(Model model, Pageable page){
        Page<Vacantes> listVacantes = repositoryVacants.findAll(page);
        model.addAttribute("vacantsList",listVacantes);
        return "vacants/listVacantes";
    }

}

