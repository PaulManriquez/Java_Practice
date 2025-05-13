package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuarios extends JpaRepository<Usuarios,Integer> {
}
