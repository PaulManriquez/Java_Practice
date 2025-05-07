package com.example.ORM1;

import com.example.ORM1.Repository.PersonDetailsRepository;
import com.example.ORM1.Repository.PersonRepository;
import com.example.ORM1.model.Person;
import com.example.ORM1.model.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

/*
* Programmer:Paul Manriquez
* Date: may 6 2025
* Goal: Understand One to One JPA
* */

@SpringBootApplication
public class Orm1Application implements CommandLineRunner {

	@Autowired
	private PersonRepository repoPerson;

	@Autowired
	private PersonDetailsRepository repoPersonDetails;

	public static void main(String[] args) {
		SpringApplication.run(Orm1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============= RUNNING =============");

		//============= PERSON
		//Create
		//insertPerson();
		//Read
		//readPersonById(3);
		//Update
		//updatePerson(2);
		//Delete
		//deletePersonById(2);
		//Display all Rows Person
		//displayAllRowsPerson();

		//============= PERSON DETAILS
		//insertPersonDetails(); // <-- WORKS just for practice
		//insertPerson();

		displayFullInformationAll();
	}

	private void insertPerson(){ //INSERT
		System.out.println("============= INSERT PERSON WITH DETAILS=============");
		Person person = new Person();
		person.setName("Person Name");
		person.setAge(22);
		repoPerson.save(person); //<--(1) Do not have the foreign key,
		//								thus, Save first

		PersonDetails person_det = new PersonDetails();
		person_det.setPhone("462-19090-60");
		person_det.setAddress("Addresss");
		person_det.setPerson(person);


		repoPersonDetails.save(person_det);//<--(2) Has the foreign key
		//									Thus, save second


		System.out.println("Saved: " + person.getName() + " " + person.getAge());
		System.out.println("=============                   =============");
	}

	private void updatePerson(int personId) { // UPDATE
		System.out.println("============= UPDATE PERSON =============");

		//Optional: object container to safely avoid nullpointer exception
		Optional<Person> optionalPerson = repoPerson.findById(personId);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.get(); // <-- Get the object
			person.setName("Updated Name");
			person.setAge(30);
			repoPerson.save(person); // save() updates if the ID is present
			System.out.println("Updated: " + person.getName() + " " + person.getAge());
		} else {
			System.out.println("Person with ID " + personId + " not found.");
		}

		System.out.println("=============                   =============");
	}

	private void deletePersonById(int personId) { // DELETE
		System.out.println("============= DELETE PERSON =============");

		// Optional: safely handle if person doesn't exist
		Optional<Person> optionalPerson = repoPerson.findById(personId);
		if (optionalPerson.isPresent()) {
			repoPerson.deleteById(personId); // or repoPerson.delete(optionalPerson.get());
			System.out.println("Deleted person with ID: " + personId);
		} else {
			System.out.println("Person with ID " + personId + " not found.");
		}

		System.out.println("=============                    =============");
	}


	private void readPersonById(int personId) { // READ
		System.out.println("============= READ PERSON =============");

		// Optional: safely retrieve the person
		Optional<Person> optionalPerson = repoPerson.findById(personId);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.get(); // Get the actual object
			System.out.println("Found: " + person.getName() + " (Age: " + person.getAge() + ")");
		} else {
			System.out.println("Person with ID " + personId + " not found.");
		}

		System.out.println("=============                  =============");
	}

	private void displayAllRowsPerson(){
		// ✅ No Optional needed: findAll() returns an Iterable, never null.
		// If no rows exist, it returns an empty list — safe to iterate.
		System.out.println("============= DISPLAYING ALL ROWS PERSON =============");
		Iterable<Person> personList = repoPerson.findAll();
		for(Person ptrPerson: personList){
			System.out.println("Name: " + ptrPerson.getName() +
					" age:" + ptrPerson.getAge());
		}
		System.out.println("=============                     =============");
	}

	//=========================================
	//=========================================
	//=========================================
	private void insertPersonDetails(){ //INSERT
		System.out.println("============= INSERT PERSON DETAILS =============");
		PersonDetails personD = new PersonDetails();
		personD.setAddress("Adreess1");
		personD.setPhone("462-190-9060");
		repoPersonDetails.save(personD);
		System.out.println("Saved: " + personD.getAddress() + " " + personD.getPhone());
		System.out.println("=============                   =============");
	}

	private void displayFullInformationAll(){
		System.out.println("============= PERSONS AND PERSONDETAILS LINKED    =============");
		List<PersonDetails> personDetailsList = repoPersonDetails.findAll();
		//Optional<Person> optionalPerson = repoPerson.findById(1);

		Optional<Person> optionalPerson;
		int i=1;
		for(PersonDetails ptrPD: personDetailsList){
			optionalPerson = Optional.ofNullable(ptrPD.getPerson());
			if(optionalPerson.isPresent()){
				System.out.println("("+i+")");
				System.out.println("Name: " + ptrPD.getPerson().getName());
				System.out.println("Age: " + ptrPD.getPerson().getAge());
				System.out.println("Address: " + ptrPD.getAddress());
				System.out.println("Phone: "+ ptrPD.getPhone());
				System.out.println("=====");
				i++;
			}
		}

	}
}
