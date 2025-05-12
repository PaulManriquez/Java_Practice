package com.example.StudentsCoursersNtoN.Repository;

import com.example.StudentsCoursersNtoN.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCourses extends JpaRepository<Course,Integer> {
}
