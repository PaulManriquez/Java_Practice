package com.example.FullDatabaseForTheWebPage.Controller;

import com.example.FullDatabaseForTheWebPage.Model.Categorias;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryCategorias;
import com.example.FullDatabaseForTheWebPage.Service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriasService categoriasService;

    //Return all the categorias in the list
    @GetMapping
    public ResponseEntity<List<Categorias>> categoriasInDataBase(){
        return new ResponseEntity<List<Categorias>>(
                categoriasService.getAllCategories(),
                HttpStatus.OK
        );
    }

    //Create a new category
    @PostMapping
    public ResponseEntity<Categorias> addCategoria(
            @RequestBody Categorias categorias){
        return new ResponseEntity<Categorias>(
                categoriasService.postANewCategory(categorias),
                HttpStatus.CREATED
        );
    }


    //Update a category
    @PutMapping("/{categoriaId}")
    public ResponseEntity<Categorias> updateCategory(
            @PathVariable("categoriaId") Integer categoriaId,
            @RequestBody Categorias categoria
    ){
        return new ResponseEntity<Categorias>(
          categoriasService.putACategory(categoriaId,categoria),
          HttpStatus.OK
        );
    }

    //Delete a category
    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable("categoriaId")Integer categoriaId
    ){
        categoriasService.deleteCategory(categoriaId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
