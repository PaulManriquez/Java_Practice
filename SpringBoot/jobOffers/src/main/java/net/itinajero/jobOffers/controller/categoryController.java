package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Service.ICategoriasService;
import net.itinajero.jobOffers.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/categories")
public class categoryController {

    //Injection
    @Autowired
    private ICategoriasService  categoriesService;

    @GetMapping("/index")
    public String displayIndex(Model model){
        List<Categoria> categoriasLista = categoriesService.buscarTodas();
        System.out.println(categoriasLista);
        model.addAttribute("ListaCategorias",categoriasLista);
        return "categories/listCategorias";
    }

    //return the template
    @GetMapping("/create")
    public String create(){
        return "categories/formCategory";
    }

    //@PostMapping("/save")
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public String saveCategoryController(
            @RequestParam("Name") String name,
            @RequestParam("Description") String description,
            Model model){

        //Create the new category
        Categoria newCategoria = new Categoria();
        newCategoria.setId( newCategoria.currentId + 1 );
        newCategoria.setNombre(name);
        newCategoria.setDescripcion(description);
        System.out.println(newCategoria.toString());

        //Save the new category created 
        categoriesService.guardar(newCategoria);

//        return "categories/listsCategories";
        return "redirect:/categories/index";
    }
}
