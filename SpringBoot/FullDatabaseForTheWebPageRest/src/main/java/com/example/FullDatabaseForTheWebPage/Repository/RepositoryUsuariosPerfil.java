package com.example.FullDatabaseForTheWebPage.Repository;

import com.example.FullDatabaseForTheWebPage.Configs.UserProfileProjection;
import com.example.FullDatabaseForTheWebPage.Model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryUsuariosPerfil extends JpaRepository<UsuarioPerfil,Integer> {

    @Query(value = """
        SELECT u.username AS username, 
               per.perfil AS perfil, 
               per.perfil AS password
        FROM usuarios u
        INNER JOIN usuario_perfil upe ON u.id = upe.idUsuario
        INNER JOIN perfiles per ON upe.idPerfil = per.id
        """, nativeQuery = true)
    List<UserProfileProjection> getUserProfiles();
}
