package com.example.FullDatabaseForTheWebPage.Service;

import com.example.FullDatabaseForTheWebPage.Model.Perfiles;
import com.example.FullDatabaseForTheWebPage.Model.UsuarioPerfil;
import com.example.FullDatabaseForTheWebPage.Model.Usuarios;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryUsuariosPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioPerfilService {
    @Autowired
    RepositoryUsuariosPerfil repositoryUsuariosPerfil;

    public void addUsuarioPerfilKeys(Usuarios usuario, Perfiles perfiles){
        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();

        usuarioPerfil.setPerfil(perfiles);
        usuarioPerfil.setUsuario(usuario);
        repositoryUsuariosPerfil.save(usuarioPerfil);
    }
}
