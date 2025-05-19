package net.itinajero.jobOffers.Servicee;


import net.itinajero.jobOffers.model.*;

import net.itinajero.jobOffers.Repository.RepositoryPerfil;
import net.itinajero.jobOffers.Repository.RepositoryUsuarios;
import net.itinajero.jobOffers.Repository.RepositoryUsuariosPerfil;

import net.itinajero.jobOffers.model.Perfiles;
import net.itinajero.jobOffers.Model.UsuarioPerfil;
import net.itinajero.jobOffers.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioPerfilService {
    @Autowired
    RepositoryUsuariosPerfil repositoryUsuariosPerfil;

    @Autowired
    RepositoryPerfil repositoryPerfil;

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

    public void addUsuarioPerfilKeys(Usuarios usuario, Perfiles perfiles){
        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();

        usuarioPerfil.setPerfil(perfiles);
        usuarioPerfil.setUsuario(usuario);
        repositoryUsuariosPerfil.save(usuarioPerfil);
    }

    public void addUsuarioPerfilFunc(){
        Usuarios usr = new Usuarios();
        Perfiles per = new Perfiles();

        usr.setNombre("newUser22");
        usr.setEmail("@mymail22");
        usr.setEstatus(1);
        usr.setPassword("askjdha");
        usr.setFechaRegistro(new Date());
        usr.setUsername("USERNAME");
        per.setPerfil("NewPerfil");


        repositoryUsuarios.save(usr);
        repositoryPerfil.save(per);
        addUsuarioPerfilKeys(usr,per);
    }
}
