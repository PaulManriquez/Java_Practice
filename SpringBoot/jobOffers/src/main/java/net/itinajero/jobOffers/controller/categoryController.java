package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.model.Categorias;
import net.itinajero.jobOffers.Repository.RepositoryCategorias;
import net.itinajero.jobOffers.Service.ICategoriasService;
import net.itinajero.jobOffers.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value="/categories")
public class categoryController {

    //Injection
    //@Autowired
    //private ICategoriasService  categoriesService;
    @Autowired
    private RepositoryCategorias repositoryCategorias;

    @GetMapping("/index")
    public String displayIndex(Model model){
//        List<Categoria> categoriasLista = categoriesService.buscarTodas();
//        System.out.println(categoriasLista);
//        model.addAttribute("ListaCategorias",categoriasLista);


        List<Categorias> categoriasList = repositoryCategorias.findAll();
        model.addAttribute("ListaCategorias",categoriasList);
        return "categories/listCategorias";
    }

    //return the template
    @GetMapping("/create")
    public String create(){
        return "categories/formCategory";
    }

    @PostMapping("/save")
    public String saveCategoryController(
            @ModelAttribute Categorias categoria,
            BindingResult result,
            RedirectAttributes attributes
            //Model model
            ) {

        if (result.hasErrors()) {
            System.out.println("An error has happened in SaveCategoryController");
            return "categories/formCategory";
        }

        //categoria.setId(categoria.currentId + 1); // manually managing ID? Consider fixing this later.
//        categoriesService.guardar(categoria);
        repositoryCategorias.save(categoria);
        attributes.addFlashAttribute("msg", "New Register Saved");

        return "redirect:/categories/index";
    }

}
