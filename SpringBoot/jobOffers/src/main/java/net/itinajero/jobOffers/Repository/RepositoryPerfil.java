package net.itinajero.jobOffers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.itinajero.jobOffers.Model.Perfiles;

public interface RepositoryPerfil extends JpaRepository<Perfiles,Integer> {
}
