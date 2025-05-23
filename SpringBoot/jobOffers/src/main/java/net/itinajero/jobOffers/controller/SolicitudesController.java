package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.model.Solicitudes;
import org.springframework.ui.Model;
import net.itinajero.jobOffers.Repository.RepositorySolicitudes;
import net.itinajero.jobOffers.Repository.RepositoryVacants;
import net.itinajero.jobOffers.Model.Vacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {

    @Autowired
    RepositoryVacants repositoryVacants;

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
    public String guardar(Solicitudes solicitud){
        System.out.println("A SOLICITUD: "+solicitud.getComentarios());
        return "redirect:/";
    }

}
