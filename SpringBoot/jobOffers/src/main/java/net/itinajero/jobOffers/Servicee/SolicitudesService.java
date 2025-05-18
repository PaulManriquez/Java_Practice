package net.itinajero.jobOffers.Servicee;


import net.itinajero.jobOffers.model.Solicitudes;
import net.itinajero.jobOffers.model.Usuarios;
import net.itinajero.jobOffers.model.Vacantes;
import net.itinajero.jobOffers.Repository.RepositorySolicitudes;
import net.itinajero.jobOffers.Repository.RepositoryUsuarios;
import net.itinajero.jobOffers.Repository.RepositoryVacants;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudesService {

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

    @Autowired
    RepositoryVacants repositoryVacants;

    @Autowired
    RepositorySolicitudes repositorySolicitudes;

    @Transactional
    public void addSolicitud(Date fecha, String archivo, String comentarios, int vacanteId, int usuarioId){

        Optional<Vacantes> optVac = repositoryVacants.findById(vacanteId);
        Optional<Usuarios> optUs = repositoryUsuarios.findById(usuarioId);

        if(optUs.isPresent() && optVac.isPresent()){
            Solicitudes solicitud = new Solicitudes();

            solicitud.setFecha(fecha);
            solicitud.setArchivo(archivo);
            solicitud.setComentarios(comentarios);
            solicitud.setUsuario(optUs.get());
            solicitud.setVacante(optVac.get());

            repositorySolicitudes.save(solicitud);
            System.out.println("A new solicitud has been submited");
        }else{
            System.out.println("The vacante or usuario Id, do not exist");
        }
    }

    @Transactional
    public void displayAllSolicitudes(){
        List<Solicitudes> solicitudes = repositorySolicitudes.findAll();
        if(!solicitudes.isEmpty()){
            for(Solicitudes ptrS:solicitudes){
                System.out.println("Solicitud:"+ptrS.getId()
                + " Vacante:" + ptrS.getVacante().getNombre()
                + " Usuario:"+ ptrS.getUsuario().getNombre());
            }
        }else{
            System.out.println("There are no data in solicitudes");
        }
    }

}
