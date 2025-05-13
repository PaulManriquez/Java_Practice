package com.example.FullDatabaseForTheWebPage.Service;

import com.example.FullDatabaseForTheWebPage.Model.Solicitudes;
import com.example.FullDatabaseForTheWebPage.Model.Usuarios;
import com.example.FullDatabaseForTheWebPage.Model.Vacantes;
import com.example.FullDatabaseForTheWebPage.Repository.RepositorySolicitudes;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryUsuarios;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryVacants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

}
