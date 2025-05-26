package net.itinajero.api.Controller;

import net.itinajero.api.Entitys.Album;
import net.itinajero.api.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumsController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAllAlbums(){
        System.out.println("================>");
        return albumService.buscarTodos();
    }

    @PostMapping("/albums")
    public Album guardar(@RequestBody Album album) {
        System.out.println("Received album: " + album);
        albumService.guardar(album);
        return album;
    }

    @PutMapping("/albums")
    public Album modificar(@RequestBody Album album){
        albumService.guardar(album);
        return album;
    }

    @DeleteMapping("/albums/{id}")
    public String eliminar(@PathVariable("id") int idAlbum){
        boolean wasDeleted = albumService.eliminar(idAlbum);
        String msg = "The album do not exist in the DB";
        if(wasDeleted){
            msg = "Deleted succesfully";
        }

        return msg;
    }

}
