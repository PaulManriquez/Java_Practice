package net.itinajero.jobOffers.Repository;

import net.itinajero.jobOffers.Model.Vacantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVacants extends JpaRepository<Vacantes,Integer> {
}
