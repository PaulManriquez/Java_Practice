package com.example.ORM3dot1.Repository;

import com.example.ORM3dot1.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStudent extends JpaRepository<Student,Integer> {
}
