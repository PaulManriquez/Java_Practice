package com.example.ORM2;

import com.example.ORM2.Model.Person2;
import com.example.ORM2.Model.Post;
import com.example.ORM2.Repository.Person2Repository;
import com.example.ORM2.Repository.PostRepository;
import com.example.ORM2.Service.Person2Service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Orm2Application implements CommandLineRunner {

	@Autowired
	private Person2Repository repoPerson2;

	@Autowired
	private PostRepository repoPosts;

	@Autowired
	private Person2Service person2Service;

	public static void main(String[] args) {
		SpringApplication.run(Orm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============ RUNING ===========");
		savePerson22();
		person2Service.setAPostToAUser(3);
		person2Service.displayPersonWithPostRelated();
	}


	@Transactional
	private void savePerson22() {
		System.out.println("========= CREATE A PERSON AND POST BY DEFAULT =========");
		Person2 p2 = new Person2();
		p2.setName("Person2 Name");
		p2.setAge(22);

		Post post = new Post();
		post.setContent("Some content");
		post.setTitle("Some title");

		p2.savePost(post); //public method of Person2 class
		repoPerson2.save(p2); // Cascade will also save post

		System.out.println("========= PERSON SAVED =========");
	}

}
