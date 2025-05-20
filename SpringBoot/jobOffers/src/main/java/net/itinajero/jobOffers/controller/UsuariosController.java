package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Repository.RepositoryUsuarios;
import net.itinajero.jobOffers.Servicee.UsuariosService;
import net.itinajero.jobOffers.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

    @Autowired
    UsuariosService usuariosService;

    @GetMapping("/index")
    public String displayUsuarios(
            Model model
    ){
        List<Usuarios> listUsuarios = repositoryUsuarios.findAll();

        model.addAttribute("usuarioL",listUsuarios);
        return "home/listUsuarios";
    }



    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") int idUsuario,
                                RedirectAttributes attributes) {

        Optional optUsr = repositoryUsuarios.findById(idUsuario);
        if(optUsr.isPresent()){
            usuariosService.deleteUsuario(idUsuario);
            attributes.addFlashAttribute("msg", "The user has been deleted");
        }else{
            usuariosService.deleteUsuario(idUsuario);
            attributes.addFlashAttribute("msg", "Error");
        }
        return "redirect:/usuarios/index";  // Redirect to the users list page
    }


}
