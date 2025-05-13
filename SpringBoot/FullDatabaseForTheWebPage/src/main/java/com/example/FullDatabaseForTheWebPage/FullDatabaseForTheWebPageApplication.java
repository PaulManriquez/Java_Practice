package com.example.FullDatabaseForTheWebPage;

import com.example.FullDatabaseForTheWebPage.Service.CategoriasService;
import com.example.FullDatabaseForTheWebPage.Service.VacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FullDatabaseForTheWebPageApplication implements CommandLineRunner {

	@Autowired
	CategoriasService categoriasService;

	@Autowired
	VacantesService vacantesService;

	public static void main(String[] args) {
		SpringApplication.run(FullDatabaseForTheWebPageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Insert a new category
//		categoriasService.insertCategoria
//				("NewCategory2","Description of the category");


		//Insert a new vacant with a category related
		vacantesService.addVacant("Nombre de Vacante",
				"Descripcion de vacante",new Date(),
				12.02,1,"no-image.png",
				"1","Some details",2);
	}
}
