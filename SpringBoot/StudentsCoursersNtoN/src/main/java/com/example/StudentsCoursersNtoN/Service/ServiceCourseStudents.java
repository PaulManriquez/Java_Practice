package com.example.StudentsCoursersNtoN.Service;

import com.example.StudentsCoursersNtoN.Model.Course;
import com.example.StudentsCoursersNtoN.Model.Student;
import com.example.StudentsCoursersNtoN.Repository.RepositoryCourses;
import com.example.StudentsCoursersNtoN.Repository.RepositoryStudent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCourseStudents {

    @Autowired
    RepositoryCourses repositoryCourses;

    @Autowired
    RepositoryStudent repositoryStudent;

    @Transactional
    public void setACourseToAStudent(int idStudent, int idCourse) {
        Optional<Student> optStudent = repositoryStudent.findById(idStudent);
        Optional<Course> optCourse = repositoryCourses.findById(idCourse);

        if (optStudent.isPresent() && optCourse.isPresent()) {
            Student student = optStudent.get();
            Course course = optCourse.get();

            // Initialize list if it's null
            if (student.getCourses() == null) {
                student.setCourses(new ArrayList<>());
            }

            // Avoid adding duplicates
            if (!student.getCourses().contains(course)) {
                student.getCourses().add(course);
            }

            repositoryStudent.save(student);
            System.out.println("The student was set to a course successfully");
        }
    }

    @Transactional
    public void getAllCoursesByStudentID(int studentID){
        Optional<Student> optStudent = repositoryStudent.findById(studentID);
        if(optStudent.isPresent()){
            Student student = optStudent.get();
            List<Course> listCourses = student.getCourses();
            System.out.println("The student " + student.getName() + " is related to:");
            for(Course ptrCourse: listCourses){
                System.out.println(ptrCourse.getTitle());
            }
            System.out.println("getAllCourses by Id successfully runned");
        }
    }

}
