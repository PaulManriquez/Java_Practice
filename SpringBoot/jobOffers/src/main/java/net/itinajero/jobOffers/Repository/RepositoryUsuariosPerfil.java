package net.itinajero.jobOffers.Repository;

import jakarta.transaction.Transactional;
import net.itinajero.jobOffers.Model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryUsuariosPerfil extends JpaRepository<UsuarioPerfil,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM UsuarioPerfil up WHERE up.usuario.id = :usuarioID")
    void deleteUsuarioPerfilOfThisIDUser(@Param("usuarioID") int usuarioID);

}
