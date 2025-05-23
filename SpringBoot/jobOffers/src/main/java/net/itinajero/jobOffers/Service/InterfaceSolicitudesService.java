package net.itinajero.jobOffers.Service;

import net.itinajero.jobOffers.model.Solicitudes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterfaceSolicitudesService{
    void guardar(Solicitudes solicitud);
    void eliminar(Integer idSolicitud);
    public Solicitudes buscarPorID(Integer idSolicitud);
    public Page<Solicitudes> getTodasbyPage(Pageable page);
}