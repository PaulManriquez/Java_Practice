package com.example.UniversityLazy.Repository;

import com.example.UniversityLazy.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryStudent extends JpaRepository<Student,Integer> {

    List<Student> findByName(String nameTosearch);

    // Query to find students by name and university ID using AND condition
    List<Student> findByNameAndUniversityId(String name, Integer universityId);


}
