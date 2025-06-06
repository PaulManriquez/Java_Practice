package net.itinajero.jobOffers.Repository;

import net.itinajero.jobOffers.Model.Vacantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryVacants extends JpaRepository<Vacantes,Integer> {

    @Query("SELECT v FROM Vacantes v WHERE v.destacado = 1 AND v.estatus = 'Aprobada'")
    List<Vacantes> findDestacadosAprobados();

    @Query("SELECT COUNT(v) FROM Vacantes v WHERE v.categoria.id = :categoriaID")
    long countByCategoriaId(@Param("categoriaID") int categoriaID);

    @Query("SELECT v FROM Vacantes v WHERE v.categoria.id = :categoriaID")
    List<Vacantes> vacantesToUpdate(@Param("categoriaID") int categoriaID);

}
