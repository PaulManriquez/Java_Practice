package net.itinajero.jobOffers.controller;

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

    @PostMapping("/save")
    public String saveCategoryController(
            @ModelAttribute Categoria categoria,
            BindingResult result,
            RedirectAttributes attributes,
            Model model) {

        if (result.hasErrors()) {
            System.out.println("An error has happened in SaveCategoryController");
            return "categories/formCategory";
        }

        categoria.setId(categoria.currentId + 1); // manually managing ID? Consider fixing this later.
        categoriesService.guardar(categoria);
        attributes.addFlashAttribute("msg", "New Register Saved");

        return "redirect:/categories/index";
    }


//    //@PostMapping("/save")
//    @RequestMapping(value = "/save",method=RequestMethod.POST)
//    public String saveCategoryController(
//            @RequestParam("Name") String name,
//            @RequestParam("Description") String description,
//            RedirectAttributes attributes,
//            BindingResult result,
//            Model model){
//
////        if (result.hasErrors()){
////            System.out.println("An error has happenned in SaveCategoryController");
////            return "categories/formCategory";
////        }
//
//        //Create the new category
//        Categoria newCategoria = new Categoria();
//        newCategoria.setId( newCategoria.currentId + 1 );
//        newCategoria.setNombre(name);
//        newCategoria.setDescripcion(description);
//        System.out.println(newCategoria.toString());
//
//        //Save the new category created
//        categoriesService.guardar(newCategoria);
//        attributes.addFlashAttribute("msg", "New Register Saved");
////        return "categories/listsCategories";
//        return "redirect:/categories/index";
//    }

}
