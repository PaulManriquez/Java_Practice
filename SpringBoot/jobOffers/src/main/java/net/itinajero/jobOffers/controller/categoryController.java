package net.itinajero.jobOffers.controller;

import net.itinajero.jobOffers.Repository.RepositoryVacants;
import net.itinajero.jobOffers.model.Categorias;
import net.itinajero.jobOffers.Repository.RepositoryCategorias;
import net.itinajero.jobOffers.Service.ICategoriasService;
import net.itinajero.jobOffers.model.Categoria;
import net.itinajero.jobOffers.model.Vacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/categories")
public class categoryController {

    //Injection
    //@Autowired
    //private ICategoriasService  categoriesService;
    @Autowired
    private RepositoryCategorias repositoryCategorias;

    @Autowired
    private RepositoryVacants repositoryVacants;

    @GetMapping("/index")
    public String displayIndex(Model model){
//        List<Categoria> categoriasLista = categoriesService.buscarTodas();
//        System.out.println(categoriasLista);
//        model.addAttribute("ListaCategorias",categoriasLista);

        List<Categorias> categoriasList = repositoryCategorias.findAll();
        model.addAttribute("ListaCategorias",categoriasList);
        return "categories/listCategorias";
    }

    @PostMapping("/edit")
    public String updateCategoria(
            @RequestParam("id") int idCategory,
            RedirectAttributes redirectAttributes,
            Model model
    ){
        System.out.println("======> ID("+idCategory + ")");

        Optional<Categorias> cat = repositoryCategorias.findById(idCategory);
        if(cat.isPresent()){
            Categorias catToEdit = cat.get();
            model.addAttribute("categoriaObj", catToEdit);
            return "categories/formCategory";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Categoria no existe");
            return "redirect:/categories/index";
        }
    }


    //return the template
    @GetMapping("/create")
    public String createCategoria(Categorias catToEdit,
                         Model model){
        model.addAttribute("categoriaObj",catToEdit);
        return "categories/formCategory";
    }

    // Spring will look for the existence of this id , if exist UPDATE else CREATE
    // <input type="hidden" th:field="*{id}" />
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


    @PostMapping("/delete")
    public String deleteVacant(
            @RequestParam("id") int idCategory,
            RedirectAttributes redirectAttributes) {

        Optional categoryToDelete = repositoryCategorias.findById(idCategory);
        if(categoryToDelete.isPresent() && idCategory!= 1){//1 is the default category, it cant be deleted
            //Get all the vacantes who category was idCategory
            List<Vacantes> toUpdate = repositoryVacants.vacantesToUpdate(idCategory);
            Optional defaultCategory = repositoryCategorias.findById(1);
            if(defaultCategory.isPresent()){
                Categorias cat = (Categorias) defaultCategory.get();
                for(Vacantes ptrV:toUpdate){
                    //Update each vacante to a default category
                    ptrV.setCategoria(cat);
                }
                repositoryCategorias.deleteById(idCategory); // <-- The category has been deleted
            }
            // Add a success message to be shown after deletion
            redirectAttributes.addFlashAttribute("msg", "Categoria eliminada con éxito.");
        }else{
            if(idCategory==1){
                redirectAttributes.addFlashAttribute("msg", "No se puede eliminar la categoria por default 1");
            }else{
                redirectAttributes.addFlashAttribute("msg", "Error al eliminar la categoria");
            }
        }
        return "redirect:/categories/index";
    }




}
