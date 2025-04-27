package net.itinajero.jobOffers.Service;

import net.itinajero.jobOffers.model.Vacancy;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantServices_I implements IVacantsService{

    private List<Vacancy> listVacancies = null;

    public VacantServices_I(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        listVacancies = new LinkedList<Vacancy>();

        try{
            //Job offer 1
            Vacancy vacancy1 = new Vacancy();
            vacancy1.setId(1);
            vacancy1.setName("Vacancy 1");
            vacancy1.setDescription("Description 1");
            vacancy1.setDate(sdf.parse("08-02-2025"));
            vacancy1.setSalary(222.01);
            vacancy1.setExcels(1);
            vacancy1.setImage("logo1.png");

            //Job offer 2
            Vacancy vacancy2 = new Vacancy();
            vacancy2.setId(2);
            vacancy2.setName("Vacancy 2");
            vacancy2.setDescription("Description 2");
            vacancy2.setDate(sdf.parse("08-02-2025"));
            vacancy2.setSalary(22.02);
            vacancy2.setExcels(0);
            vacancy2.setImage("logo2.png");

            //Job offer 3
            Vacancy vacancy3 = new Vacancy();
            vacancy3.setId(3);
            vacancy3.setName("Vacancy 3");
            vacancy3.setDescription("Description 3");
            vacancy3.setDate(sdf.parse("08-02-2025"));
            vacancy3.setSalary(22.03);
            vacancy3.setExcels(1);
            vacancy3.setImage("logo3.png");

            //
            listVacancies.add(vacancy1);
            listVacancies.add(vacancy2);
            listVacancies.add(vacancy3);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vacancy> searchAllVacants(){

        return listVacancies;
    }

    @Override
    public Vacancy searchByID(Integer idVacant){

        for(Vacancy ptrV : listVacancies){
            if(ptrV.getId()==idVacant) return ptrV;
        }

        return null;
    }

    @Override
    public void save(Vacancy vacant) {
        listVacancies.add(vacant);
    }
}
