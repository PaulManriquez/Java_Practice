package com.example.FullDatabaseForTheWebPage.Service;

import com.example.FullDatabaseForTheWebPage.Model.Usuarios;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuariosService {

    @Autowired
    RepositoryUsuarios repositoryUsuarios;

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
}
