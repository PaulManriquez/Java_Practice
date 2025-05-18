package net.itinajero.jobOffers.Repository;

import net.itinajero.jobOffers.model.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySolicitudes extends JpaRepository<Solicitudes,Integer> {
}
