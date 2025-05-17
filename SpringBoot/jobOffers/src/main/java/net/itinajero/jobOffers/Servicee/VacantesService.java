package net.itinajero.jobOffers.Servicee;


import net.itinajero.jobOffers.Model.Categorias;
import net.itinajero.jobOffers.Model.Vacantes;
import net.itinajero.jobOffers.Repository.RepositoryCategorias;
import net.itinajero.jobOffers.Repository.RepositoryVacants;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VacantesService {

    @Autowired
    RepositoryCategorias repositoryCategorias;

    @Autowired
    RepositoryVacants repositoryVacants;



    @Transactional
    public void addVacant(String nombre, String description, Date fecha, Double salario,
                          Integer destacado, String imagen, String estatus, String detalles, int idCategory) {

        Optional<Categorias> optCat = repositoryCategorias.findById(idCategory);

        if (optCat.isPresent()) {
            Categorias cat = optCat.get();

            Vacantes vac = createVacant(nombre, description, fecha, salario, destacado, imagen, estatus, detalles);
            vac.setCategoria(cat);
            cat.getVacantes().add(vac);

            repositoryVacants.save(vac); // Only saving the owning side is needed

            System.out.println("The vacant '" + vac.getNombre() + "' with the category '" +
                    cat.getNombre() + "' was successfully created.");

            // Optional: Display all current vacancies in this category
            List<Vacantes> listVac = cat.getVacantes();
            System.out.println("This category holds the following vacancies:");
            for (Vacantes ptrVac : listVac) {
                System.out.println(ptrVac.getNombre());
            }

        } else {
            System.out.println("The vacancy couldn't be created because the category does not exist.");
        }
    }


    private Vacantes createVacant(String nombre, String description, Date fecha, Double salario,
                                  Integer destacado, String imagen, String estatus, String detalles){
        Vacantes vacante = new Vacantes();

        vacante.setNombre(nombre);
        vacante.setDescription(description);
        vacante.setFecha(fecha);
        vacante.setSalario(salario);
        vacante.setDestacado(destacado);
        vacante.setImagen(imagen);
        vacante.setEstatus(estatus);
        vacante.setDetalles(detalles);

        repositoryVacants.save(vacante);
        return vacante;
    }



}
