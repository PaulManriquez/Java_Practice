package com.example.StudentsCoursersNtoN.Repository;

import com.example.StudentsCoursersNtoN.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStudent extends JpaRepository<Student,Integer> {
}
