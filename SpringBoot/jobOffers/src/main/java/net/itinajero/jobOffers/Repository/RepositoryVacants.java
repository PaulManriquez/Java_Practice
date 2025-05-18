package net.itinajero.jobOffers.Repository;

import net.itinajero.jobOffers.model.Vacantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVacants extends JpaRepository<Vacantes,Integer> {
}
