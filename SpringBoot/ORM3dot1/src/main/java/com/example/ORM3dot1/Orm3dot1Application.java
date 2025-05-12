package com.example.ORM3dot1;

import com.example.ORM3dot1.Model.Student;
import com.example.ORM3dot1.Model.University;
import com.example.ORM3dot1.Repository.RepositoryStudent;
import com.example.ORM3dot1.Repository.RepositoryUniveristy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ORM3dot1.Service.UniversityService;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootApplication
public class Orm3dot1Application implements CommandLineRunner {

	@Autowired
	RepositoryUniveristy repoUniversity;
	@Autowired
	RepositoryStudent repoStudent;

	public static void main(String[] args) {
		SpringApplication.run(Orm3dot1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===== RUNNING =====");
		//createUniversity("MonstersInc");
		//createStudent("Paul");
		UniversityService.UniversityService.linkStudentToUniversity(1, 1);
	}

	private void createUniversity(String universityName){
		University university = new University();
		university.setName(universityName);
		repoUniversity.save(university);
		System.out.println("A new university " +
				universityName + " has been created");
		System.out.println("<================ createUniversity()");
	}

	private void createStudent(String name){
		Student student = new Student();
		student.setName(name);
		System.out.println("A new student " +
				name + " has been created");
		System.out.println("<================ createStudent()");
		repoStudent.save(student);
	}

//	private void linkAStudentWithAuniversity(int idU,int idS){
//		Optional<Student> student = repoStudent.findById(idS);
//		Optional<University> university = repoUniversity.findById(idU);
//
//		if(student.isPresent() && university.isPresent()){
//			University uni = university.get();
//			Student stu = student.get();
//
//			uni.setStudent(stu);
//			repoUniversity.save(uni);
//			System.out.println("The university " + uni.getName()
//			+ " has been linked to the student " + stu.getName());
//		}else{
//			System.out.println("University or Student or Both do no exist in the data base");
//		}
//
//	}


//	@Transactional
//	public void linkAStudentWithAuniversity(int idU, int idS) {
//		Optional<Student> student = repoStudent.findById(idS);
//		Optional<University> university = repoUniversity.findById(idU);
//
//		if (student.isPresent() && university.isPresent()) {
//			University uni = university.get();
//			Student stu = student.get();
//
//			// Force lazy collection to initialize
//			uni.getStudents().size();
//
//			// Set the relationship
//			uni.getStudents().add(stu);
//			stu.setUniversity(uni); // keep bidirectional sync
//
//			// Save both sides
//			repoStudent.save(stu);
//			repoUniversity.save(uni);
//
//			System.out.println("The university " + uni.getName()
//					+ " has been linked to the student " + stu.getName());
//		} else {
//			System.out.println("University or Student or Both do not exist in the database");
//		}
//	}


}
