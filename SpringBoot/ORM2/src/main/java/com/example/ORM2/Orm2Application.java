package com.example.ORM2;

import com.example.ORM2.Model.Person2;
import com.example.ORM2.Repository.Person2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Orm2Application implements CommandLineRunner {

	@Autowired
	private Person2Repository repoPerson2;

	public static void main(String[] args) {
		SpringApplication.run(Orm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============ RUNING ===========");
		savePerson2();
	}


	private void savePerson2(){
		Person2 p2 = new Person2();
		p2.setName("Person2 Name");
		p2.setAge(22);
		repoPerson2.save(p2);
		System.out.println("========= PERSON SAVED =========");
	}

}
