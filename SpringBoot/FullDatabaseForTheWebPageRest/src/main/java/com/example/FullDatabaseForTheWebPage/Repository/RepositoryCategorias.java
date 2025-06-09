package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategorias extends JpaRepository<Categorias,Integer> {



}
