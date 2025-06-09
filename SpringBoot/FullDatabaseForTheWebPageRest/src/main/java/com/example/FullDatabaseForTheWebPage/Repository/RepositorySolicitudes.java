package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Model.Solicitudes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface RepositorySolicitudes extends JpaRepository<Solicitudes,Integer> {

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Solicitudes s WHERE s.vacante.id = :vacanteId")
//    void deleteSolicitudByVacanteID(@Param("vacanteId") Integer vacanteId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Solicitudes s WHERE s.vacante.id = :vacanteId")
    public void deleteSolicitudByVacanteID(@Param("vacanteId")Integer vacanteId);
}
