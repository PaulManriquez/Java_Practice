package net.itinajero.jobOffers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categories")
public class categoryController {

    @GetMapping("/index")
    public String displayIndex(Model model){
        return "categories/listsCategories";
    }

    @GetMapping("/create")
    public String create(){
        return "categories/formCategory";
    }

    @PostMapping("/save")
    public String saveCategoryController(
            @RequestParam("Name") String name,
            @RequestParam("Description") String description){

        System.out.println("Category: " + name);
        System.out.println("Description: " + description);
        return "categories/listsCategories";
    }
}
