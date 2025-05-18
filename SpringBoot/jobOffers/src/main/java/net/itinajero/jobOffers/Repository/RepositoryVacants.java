package net.itinajero.jobOffers.Repository;

import net.itinajero.jobOffers.model.Vacantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryVacants extends JpaRepository<Vacantes,Integer> {

    @Query("SELECT v FROM Vacantes v WHERE v.destacado = 1 AND v.estatus = 'Aprobada'")
    List<Vacantes> findDestacadosAprobados();

}
