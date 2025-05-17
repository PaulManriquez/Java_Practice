package net.itinajero.jobOffers.Repository;

//import com.example.FullDatabaseForTheWebPage.Model.Categorias;
import net.itinajero.jobOffers.Model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCategorias extends JpaRepository<Categorias,Integer> {
}
