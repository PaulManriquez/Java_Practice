package net.itinajero.api.Service;

import net.itinajero.api.Entitys.Album;

import java.util.List;

public interface IAlbumService {
    List<Album> buscarTodos();
    void guardar(Album album);
    boolean eliminar(int idAlbum);
}
