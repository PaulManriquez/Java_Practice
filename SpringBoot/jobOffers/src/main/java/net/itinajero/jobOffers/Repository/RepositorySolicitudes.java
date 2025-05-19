package net.itinajero.jobOffers.Repository;

import jakarta.transaction.Transactional;
import net.itinajero.jobOffers.model.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositorySolicitudes extends JpaRepository<Solicitudes,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Solicitudes s WHERE s.vacante.id = :idVacante")
    void deleteByVacanteId(@Param("idVacante") int idVacante);


}
