package net.itinajero.jobOffers.Service;

import net.itinajero.jobOffers.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

    private List<Categoria> listaDeCategorias = null;

    public CategoriasServiceImpl(){
        listaDeCategorias = new LinkedList<Categoria>();
    }

    //Return all the categories existent in the list
    @Override
    public List<Categoria> buscarTodas(){
        return listaDeCategorias;
    }

    //Search for the corresponding object by ID
    @Override
    public Categoria buscarPorId(Integer id){
        for(Categoria ptrCat : listaDeCategorias){
            if(ptrCat.getId() == id){
                return ptrCat;
            }
        }
        return null;
    }

    @Override
    public void guardar(Categoria categoria){
        listaDeCategorias.add(categoria);
    }

}
