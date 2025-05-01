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

        Categoria categoria1 = new Categoria();
        categoria1.setId(++Categoria.currentId);
        categoria1.setDescripcion("Ventas descripcion");
        categoria1.setNombre("Ventas");

        Categoria categoria2 = new Categoria();
        categoria2.setId(++Categoria.currentId);
        categoria2.setDescripcion("Transporte descripcion");
        categoria2.setNombre("Transporte");

        Categoria categoria3 = new Categoria();
        categoria3.setId(++Categoria.currentId);
        categoria3.setDescripcion("Otros descripcion");
        categoria3.setNombre("Otros");

        listaDeCategorias.add(categoria1);
        listaDeCategorias.add(categoria2);
        listaDeCategorias.add(categoria3);
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
