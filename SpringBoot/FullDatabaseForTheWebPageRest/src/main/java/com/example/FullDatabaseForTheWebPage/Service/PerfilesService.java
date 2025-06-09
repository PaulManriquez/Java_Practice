package com.example.FullDatabaseForTheWebPage.Service;

import com.example.FullDatabaseForTheWebPage.Model.Perfiles;
import com.example.FullDatabaseForTheWebPage.Repository.RepositoryPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilesService {

    @Autowired
    RepositoryPerfil repositoryPerfil;

    public void addPerfil(String perfils){
        Perfiles perfil = new Perfiles();
        perfil.setPerfil(perfils);
        repositoryPerfil.save(perfil);
        System.out.println("The perfil was created successfully");
    }
}
