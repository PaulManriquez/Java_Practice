package com.example.StudentsCoursersNtoN.Service;

import com.example.StudentsCoursersNtoN.Model.Student;
import com.example.StudentsCoursersNtoN.Repository.RepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStudent {

    @Autowired
    private RepositoryStudent repositoryStudent;

    public void addStudent(String name){
        Student student = new Student();
        student.setName(name);
        repositoryStudent.save(student);
        System.out.println("Student saved successfully");
    }
}
