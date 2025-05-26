package net.itinajero.api.Service;

import net.itinajero.api.Entitys.Album;
import net.itinajero.api.Repositorys.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements IAlbumService{

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public List<Album> buscarTodos() {
        return albumRepository.findAll();
    }

    @Override
    public void guardar(Album album) {
        albumRepository.save(album);
    }

    @Override
    public boolean eliminar(int idAlbum) {
        Optional optEliminar = albumRepository.findById(idAlbum);
        if(optEliminar.isPresent()){
            albumRepository.deleteById(idAlbum);
            return true;
        }
        return false;
    }

}
