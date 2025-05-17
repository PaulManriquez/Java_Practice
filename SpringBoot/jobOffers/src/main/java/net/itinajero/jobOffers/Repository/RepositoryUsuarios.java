package net.itinajero.jobOffers.Repository;

import net.itinajero.jobOffers.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuarios extends JpaRepository<Usuarios,Integer> {
}
