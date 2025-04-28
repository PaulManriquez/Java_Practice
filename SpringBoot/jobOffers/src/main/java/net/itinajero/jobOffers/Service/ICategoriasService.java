package net.itinajero.jobOffers.Service;

import net.itinajero.jobOffers.model.Categoria;
import java.util.List;

public interface ICategoriasService {
    void guardar(Categoria categoria);
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
}
