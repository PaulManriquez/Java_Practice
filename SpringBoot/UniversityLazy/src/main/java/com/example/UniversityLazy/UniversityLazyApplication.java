package com.example.UniversityLazy;

import com.example.UniversityLazy.Model.Student;
import com.example.UniversityLazy.Model.University;
import com.example.UniversityLazy.Repository.RepositoryStudent;
import com.example.UniversityLazy.Repository.RepositoryUniversity;
import com.example.UniversityLazy.Service.StudentService;
import com.example.UniversityLazy.Service.UniversityService; //<==()
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;



@SpringBootApplication
public class UniversityLazyApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UniversityService universityService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityLazyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===== RUNNING =====");

		//Insert a university
		//insertUniversity("Uni1");

		//Insert a student with a university
		studentService.insertStudent("Paul3",1);

		//Get all students by university id
		//getAllStudentsByUniversity(1);
		universityService.getAllStudentsByUniversity(1);
	}

}
