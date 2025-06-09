package com.example.FullDatabaseForTheWebPage.Service;

import com.example.FullDatabaseForTheWebPage.Model.Categorias;
import com.example.FullDatabaseForTheWebPage.Model.Vacantes;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryCategorias;
import com.example.FullDatabaseForTheWebPage.Repository.RepositorySolicitudes;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryVacants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    RepositoryCategorias repositoryCategorias;

    @Autowired
    RepositoryVacants repositoryVacants;

    @Autowired
    RepositorySolicitudes repositorySolicitudes;

    public void insertCategoria(String categoriaName,String description){
        Categorias categorias = new Categorias();
        categorias.setNombre(categoriaName);
        categorias.setDescripcion(description);

        repositoryCategorias.save(categorias);
        System.out.println("Se inserto correctamente la categoria" +
                categorias.getNombre() + " " + categorias.getDescripcion());

    }

    public List<Categorias> getAllCategories(){
        return  repositoryCategorias.findAll();
    }

    public Categorias postANewCategory(Categorias categoria){
        return repositoryCategorias.save(categoria);
    }

    public Categorias putACategory(Integer categoriaId, Categorias categoria){
        Optional<Categorias> optCategoria = repositoryCategorias.findById(categoriaId);
        if(optCategoria.isPresent()){
            Categorias cat = optCategoria.get();
            cat.setDescripcion(categoria.getDescripcion());
            cat.setNombre(categoria.getNombre());
            return repositoryCategorias.save(cat);
        }else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,String.format("Category with id:%d do not exist",categoriaId));
        }
    }




    public void deleteCategory(Integer categoriaId){
        Optional<Categorias> optCategoria = repositoryCategorias.findById(categoriaId);
        if(optCategoria.isPresent()){
            Categorias cat = optCategoria.get();

            //Delete all solicitudes related to a vacant
            List<Vacantes> vacantsToDelete = repositoryVacants.getVacantesByCategoriaID(cat.getId());
            for(Vacantes ptrVac: vacantsToDelete){
                System.out.println("DELETING IN SOLICITUDES BY VACANTID==> "+ptrVac.getNombre() +" "+ptrVac.getCategoria());
                repositorySolicitudes.deleteById(ptrVac.getId());
            }

            //Delete all vacantes related to the category
            for(Vacantes ptrVac: vacantsToDelete){
                System.out.println("DELETING IN VACANTES BY VACANTID==> "+ptrVac.getNombre() +" "+ptrVac.getCategoria());
                repositoryVacants.deleteById(ptrVac.getId());
            }

            //Delete the Category
            repositoryCategorias.deleteById(cat.getId());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The category with id %d do not exist",categoriaId));
        }
    }

}
