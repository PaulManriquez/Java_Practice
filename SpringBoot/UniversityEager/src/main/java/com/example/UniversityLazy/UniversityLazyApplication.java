package com.example.UniversityLazy;

import com.example.UniversityLazy.Model.Student;
import com.example.UniversityLazy.Model.University;
import com.example.UniversityLazy.Repository.RepositoryStudent;
import com.example.UniversityLazy.Repository.RepositoryUniversity;

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
	private RepositoryUniversity repositoryUniversity;

	public static void main(String[] args) {
		SpringApplication.run(UniversityLazyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===== RUNNING =====");
		getAllStudents(1);
	}

	public void getAllStudents(int idUniversity){
		Optional<University> uni = repositoryUniversity.findById(idUniversity);
		if(uni.isPresent()){
			University university = uni.get();
			List<Student> studentList = university.getStudents();
			System.out.println("Here is the list for university: "+idUniversity);
			for(Student ptrS : studentList){
				System.out.println("Student: "+ptrS.getName() + " ID: " + ptrS.getId());
			}
		}
	}

}
