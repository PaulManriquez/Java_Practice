package com.example.FullDatabaseForTheWebPage.Service;

import com.example.FullDatabaseForTheWebPage.Model.Perfiles;
import com.example.FullDatabaseForTheWebPage.Model.UsuarioPerfil;
import com.example.FullDatabaseForTheWebPage.Model.Usuarios;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryPerfil;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryUsuarios;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryUsuariosPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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
