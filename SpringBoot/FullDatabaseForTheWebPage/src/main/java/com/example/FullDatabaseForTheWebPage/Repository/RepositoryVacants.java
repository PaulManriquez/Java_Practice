package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Model.Vacantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVacants extends JpaRepository<Vacantes,Integer> {
}
