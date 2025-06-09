package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Model.Categorias;
import com.example.FullDatabaseForTheWebPage.Model.Vacantes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RepositoryVacants extends JpaRepository<Vacantes,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Vacantes v WHERE v.categoria.id = :categoriaId")
    void deleteVacantesByCategoria(@Param("categoriaId") Integer categoriaId);

    @Query("SELECT v FROM Vacantes v WHERE v.categoria.id = :idCategoria")
    List<Vacantes> getVacantesByCategoriaID(@Param("idCategoria") Integer idCategoria);

}
