package net.itinajero.jobOffers.Service;

import java.util.List;
import net.itinajero.jobOffers.model.Vacancy;

public interface IVacantsService {
    List<Vacancy> searchAllVacants();
    Vacancy searchByID(Integer idVacant);
    void save(Vacancy vacant);
}
