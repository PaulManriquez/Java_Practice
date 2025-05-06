package net.itinajero.repository;
import net.itinajero.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante,Integer>{
}
