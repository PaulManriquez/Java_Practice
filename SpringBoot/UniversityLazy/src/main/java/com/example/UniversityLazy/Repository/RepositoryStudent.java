package com.example.UniversityLazy.Repository;

import com.example.UniversityLazy.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStudent extends JpaRepository<Student,Integer> {
}
