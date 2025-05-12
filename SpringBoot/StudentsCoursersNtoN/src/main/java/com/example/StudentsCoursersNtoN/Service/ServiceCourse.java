package com.example.StudentsCoursersNtoN.Service;

import com.example.StudentsCoursersNtoN.Model.Course;
import com.example.StudentsCoursersNtoN.Repository.RepositoryCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCourse {

    @Autowired
    private RepositoryCourses repositoryCourses;

    public void addCourse(String courseName){
        Course course = new Course();
        course.setTitle(courseName);

        repositoryCourses.save(course);
        System.out.println("The course was saved successfully");
    }
}
