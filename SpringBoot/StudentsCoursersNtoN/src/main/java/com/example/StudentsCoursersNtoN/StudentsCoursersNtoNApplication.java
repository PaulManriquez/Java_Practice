package com.example.StudentsCoursersNtoN;

import com.example.StudentsCoursersNtoN.Service.ServiceCourse;
import com.example.StudentsCoursersNtoN.Service.ServiceCourseStudents;
import com.example.StudentsCoursersNtoN.Service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsCoursersNtoNApplication implements CommandLineRunner {

	@Autowired
	private ServiceStudent serviceStudent;

	@Autowired
	private ServiceCourse serviceCourse;

	@Autowired
	private ServiceCourseStudents serviceCourseStudents;

	public static void main(String[] args) {
		SpringApplication.run(StudentsCoursersNtoNApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== RUNNING ===");

		//serviceStudent.addStudent("Paul");

//		serviceCourse.addCourse("Some other course");
//
//		serviceCourseStudents.setACourseToAStudent(1,2);

		serviceCourseStudents.getAllCoursesByStudentID(1);
	}
}
