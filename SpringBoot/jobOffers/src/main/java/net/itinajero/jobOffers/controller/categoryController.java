package net.itinajero.jobOffers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/categories")
public class categoryController {

    @GetMapping("/index")
    public String displayIndex(Model model){
        return "categories/listsCategories";
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

        System.out.println("Category: " + name);
        System.out.println("Description: " + description);

        model.addAttribute("Name",name);
        model.addAttribute("Description",description);

        return "categories/listsCategories";
    }
}
