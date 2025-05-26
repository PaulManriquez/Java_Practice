package net.itinajero.api.Repositorys;

import net.itinajero.api.Entitys.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
