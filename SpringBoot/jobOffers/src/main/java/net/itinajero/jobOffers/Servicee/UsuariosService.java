package net.itinajero.jobOffers.Servicee;


import jakarta.transaction.Transactional;
import net.itinajero.jobOffers.Repository.RepositorySolicitudes;
import net.itinajero.jobOffers.Repository.RepositoryUsuariosPerfil;
import net.itinajero.jobOffers.model.Usuarios;
import net.itinajero.jobOffers.Repository.RepositoryUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

    @Autowired
    RepositorySolicitudes repositorySolicitudes;

    @Autowired
    RepositoryUsuariosPerfil repositoryUsuariosPerfil;

    public void addUsuario(String nombre, String email, String username, String password, int estatus, Date fechaRegistro){
        Usuarios usuario = new Usuarios();

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEstatus(estatus);
        usuario.setFechaRegistro(fechaRegistro);

        repositoryUsuarios.save(usuario);
        System.out.println("The usuario "+ usuario.getNombre() + " was Saved successfully");
    }

    @Transactional
    public void deleteUsuario(int idUsuario){
        Optional optUsu = repositoryUsuarios.findById(idUsuario);
        if(optUsu.isPresent()){
            Usuarios usrToDelete =(Usuarios) optUsu.get();
            repositorySolicitudes.deleteSolicitudesOfThisIDUser(idUsuario);
            repositoryUsuariosPerfil.deleteUsuarioPerfilOfThisIDUser(idUsuario);

            repositoryUsuarios.deleteById(idUsuario);
        }
    }
}
