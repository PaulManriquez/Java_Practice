package com.example.UniversityLazy.Service;

import com.example.UniversityLazy.Model.Student;
import com.example.UniversityLazy.Model.University;
import com.example.UniversityLazy.Repository.RepositoryUniversity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    private RepositoryUniversity repoUniversity;

    public void insertUniversity(String name){
        University uni = new University();
        uni.setName(name);
        repoUniversity.save(uni);
        System.out.println("University added to the table <===()");
    }

    //SESSION IN HIBERNATE: A temporary connection between your application and the database,
    // 						where Hibernate manages things like fetching data,
    // 						tracking changes to entities, lazy loading, etc.
    @Transactional
    public void getAllStudentsByUniversity(int id_university){
        Optional<University> uni = repoUniversity.findById(id_university);
        if(uni.isPresent()){
            University university = uni.get();
            List<Student> studentsList = university.getStudents();

            System.out.println("University: " + university.getName());
            for(Student ptrStudent: studentsList){
                System.out.println("Name: " + ptrStudent.getName());
            }

            System.out.println("GET ALL STUDENTS RELATED TO THE UNIVERSITY SUCCESSFULL <==()");
        } else {
            System.out.println("THERE WAS AN ERROR");
        }
    }
}
