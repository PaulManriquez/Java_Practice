package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Repository.RepositoryUsuarios;
import net.itinajero.jobOffers.Servicee.SolicitudesService;
import net.itinajero.jobOffers.model.Solicitudes;
import net.itinajero.jobOffers.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import net.itinajero.jobOffers.Repository.RepositorySolicitudes;
import net.itinajero.jobOffers.Repository.RepositoryVacants;
import net.itinajero.jobOffers.Model.Vacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.Utils;

import java.io.File;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {

    @Autowired
    RepositoryVacants repositoryVacants;

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

    @Autowired
    RepositorySolicitudes repositorySolicitudes;

    @Autowired
    SolicitudesService solicitudesService;

    @GetMapping("/create/{idVacante}")
    public String crear(@PathVariable("idVacante") Integer idVacante,
                        Model model){
            System.out.println(idVacante);

        Optional optVacante = repositoryVacants.findById(idVacante);
        model.addAttribute("vacante",(Vacantes)optVacante.get());

        model.addAttribute("solicitudes", new Solicitudes());

        return "solicitudes/formSolicitud";
    }

    @PostMapping("/save")
    public String guardar(Solicitudes solicitud,
                          BindingResult result,
                          Authentication authentication,
                          RedirectAttributes attributes,
                          @RequestParam("vacante.id") Integer vacanteId,
                          @RequestParam("archivoCV") MultipartFile multiPart){
        String myfileName ="";
        if (authentication == null) {
            // Handle unauthenticated user properly here
            System.out.println("No user authenticated!");
            return "redirect:/login"; // or return an error page
        }

        String userNameInSession = authentication.getName();
        Usuarios user = repositoryUsuarios.findByUsername(userNameInSession);
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("An error has happened: " + error.getDefaultMessage());
            }
            return "solicitudes/formSolicitud";
        }

        //Find the user that you will set this

        //Save the file in the path and set the filename in the data base corresponding to Solicitudes class
        if (!multiPart.isEmpty()) {
            //File name is what comes from html name="archivoCV" | Save the file in the tmp directory path
            String fileName = Utils.saveFile(multiPart, uploadDir + File.separator
                    + "files" + File.separator); //files is a directory root created
            myfileName = fileName;
            if (fileName != null) {
                solicitud.setArchivo(fileName);
            }
        }


        Optional optVac = repositoryVacants.findById(vacanteId);
        solicitud.setFecha(new Date());
        solicitud.setUsuario(user);
        solicitud.setVacante((Vacantes) optVac.get());

        repositorySolicitudes.save(solicitud);
        attributes.addFlashAttribute("msg","Thank you for sending your CV");
        System.out.println(" A SOLICITUD: "+solicitud.getComentarios() + " FileName:" + myfileName);
        return "redirect:/";
    }

    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;


    @GetMapping("/indexPaginate")
    public String mostrarIndexPaginado(Model model, Pageable page){
        Page<Solicitudes> listaSolicitudes = repositorySolicitudes.findAll(page);
        model.addAttribute("solicitudes",listaSolicitudes);

        for (Solicitudes s : listaSolicitudes) {
            System.out.println("Archivo attached: " + s.getArchivo());
        }

        


        return "solicitudes/listSolicitudes";
    }

}
