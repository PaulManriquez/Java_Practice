package com.example.ORM2;

import com.example.ORM2.Model.Person2;
import com.example.ORM2.Model.Post;
import com.example.ORM2.Repository.Person2Repository;
import com.example.ORM2.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Orm2Application implements CommandLineRunner {

	@Autowired
	private Person2Repository repoPerson2;

	@Autowired
	private PostRepository repoPosts;

	public static void main(String[] args) {
		SpringApplication.run(Orm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============ RUNING ===========");
//		savePerson2();
		savePersonWithPost();
	}


	private void savePerson2(){
		Person2 p2 = new Person2();
		p2.setName("Person2 Name");
		p2.setAge(22);
		repoPerson2.save(p2);
		System.out.println("========= PERSON SAVED =========");
	}


	private void savePersonWithPost() {
		Person2 per2 = new Person2();
		per2.setAge(23);
		per2.setName("Gutierritos");

		// Create and add post before saving the person
		Post pst = new Post();
		pst.setContent("This is the content");
		pst.setTitle("Title of the post");

		per2.addPost(pst); // This will set person2 internally and add to list

		// Save only the parent; post will be saved because of CascadeType.ALL
		repoPerson2.save(per2);
	}


}
