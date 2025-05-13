package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Model.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySolicitudes extends JpaRepository<Solicitudes,Integer> {
}
