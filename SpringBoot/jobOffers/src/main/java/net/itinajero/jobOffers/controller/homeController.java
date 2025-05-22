package net.itinajero.jobOffers.controller;
import net.itinajero.jobOffers.Repository.*;
import net.itinajero.jobOffers.Service.IVacantsService;
import net.itinajero.jobOffers.Servicee.UsuariosService;
import net.itinajero.jobOffers.Servicee.VacantesService;
import net.itinajero.jobOffers.Model.UsuarioPerfil;
import net.itinajero.jobOffers.model.*;
import net.itinajero.jobOffers.model.Categorias;
import net.itinajero.jobOffers.model.Perfiles;
import net.itinajero.jobOffers.model.Usuarios;
import net.itinajero.jobOffers.model.Vacantes;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private VacantesService vacantesService;

    @Autowired
    private RepositoryPerfil repositoryPerfil;

    @Autowired
    private RepositoryUsuariosPerfil repositoryUsuariosPerfil;

    @Autowired
    private RepositoryUsuarios repositoryUsuarios;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private RepositoryCategorias repositoryCategorias;

    //=======================================
    @GetMapping("/")
    public String displayHome(Model model){
//        List<Vacantes> listVacancies = repositoryVacants.findAll();
        List<Vacantes> listVacancies = vacantesService.getDestacadosAprobados();
        List<Categorias> listCategorias = repositoryCategorias.findAll();

        // Log the image path to see if it matches what you expect
//        for (Vacantes ptrV : listVacancies) {
//            String imagePath = "/uploads/" + ptrV.getImagen(); // This matches the URL path you will use
//            System.out.println("Image URL path for image " + ptrV.getImagen() + ": " + imagePath);
//        }

        model.addAttribute("vacantsList", listVacancies);
        model.addAttribute("categoriasList",listCategorias);
        return "home";
    }

    @GetMapping("/search")
    public String searchVacantesBySelect(
            @ModelAttribute("searchVac") Vacantes vacante, //Certain properties of an object are filled
            Model model
    ){
        System.out.println("Searching... ===>"+ vacante);
        List<Categorias> listCategorias = repositoryCategorias.findAll();
        model.addAttribute("categoriasList",listCategorias);

        //==== Find all the vacantes based on the e(xample)
        //Execute the query as LIKE for the column 'description'
        ExampleMatcher matcher =
                ExampleMatcher.matching().
                        withMatcher("description",
                                ExampleMatcher.GenericPropertyMatchers.contains());
        //====
        Example<Vacantes> example = Example.of(vacante,matcher);
        List<Vacantes> listV = repositoryVacants.findAll(example);
        //========================================================
        model.addAttribute("vacantsList",listV);

        return "home";
    }

    //InitiBinder to Strings, detects if several empty strings are in the data binding
    //and will set them to null vid(125)
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //Set objects String property from '' to null
        binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public void setGenericos(Model model){

        //======================================================
        Vacantes vacanteSearch = new Vacantes();
        vacanteSearch.reset();//Set as null to the image attribute
        model.addAttribute("searchVac",vacanteSearch);
        //======================================================
    }

    //Returns the form to register
    @GetMapping("/registrarse")
    public String registrarsePage(){
        return "formRegistro";
    }

    @PostMapping("/saveRegistro")
    public String saveRegister(
            Usuarios usuario,
            RedirectAttributes attributes
    ){


        Optional optPerfil = repositoryPerfil.findById(1);
        if(optPerfil.isPresent()){
            Perfiles per = (Perfiles) optPerfil.get(); //Get the perfil concerning to this user

            Date currentDate = (Date) getDateFormattedAsDate();//Formated Date
            usuario.setFechaRegistro(currentDate);//Set Date to usuario
            usuario.setEstatus(1);//Set estatus

            UsuarioPerfil usp = new UsuarioPerfil();//new usuarioPerfil related
            usp.setUsuario(usuario);//Set Usuario
            usp.setPerfil(per);//Set perfil


            repositoryUsuarios.save(usuario);
            repositoryUsuariosPerfil.save(usp);

            attributes.addFlashAttribute("msg", "New User Saved");


            return "redirect:/registrarse";
        }
        return "redirect:/registrarse"; //When redirects, redirects to an endpoint
    }

    public static Date getDateFormattedAsDate() {
        try {
            String dateString = "2025-05-14 09:23:06";  // Or getDateFormated()
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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


    @GetMapping("/index")
    public String mostrarIndex(Authentication auth){
        String username = auth.getName();
        System.out.println("====> " + username);
        return "redirect:/";
    }
}
