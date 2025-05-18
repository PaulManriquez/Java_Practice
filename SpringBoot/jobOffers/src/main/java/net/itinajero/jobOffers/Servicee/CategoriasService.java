package net.itinajero.jobOffers.Servicee;


import net.itinajero.jobOffers.Repository.RepositoryCategorias;
import net.itinajero.jobOffers.model.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {

    @Autowired
    RepositoryCategorias repositoryCategorias;

    public void insertCategoria(String categoriaName,String description){
        Categorias categorias = new Categorias();
        categorias.setNombre(categoriaName);
        categorias.setDescripcion(description);

        repositoryCategorias.save(categorias);
        System.out.println("Se inserto correctamente la categoria" +
                categorias.getNombre() + " " + categorias.getDescripcion());

    }
}
