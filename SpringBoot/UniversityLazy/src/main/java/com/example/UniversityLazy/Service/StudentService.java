package com.example.UniversityLazy.Service;

import com.example.UniversityLazy.Model.Student;
import com.example.UniversityLazy.Model.University;
import com.example.UniversityLazy.Repository.RepositoryStudent;
import com.example.UniversityLazy.Repository.RepositoryUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private RepositoryUniversity repositoryUniversity;

    @Autowired
    private RepositoryStudent repositoryStudent;

    public void insertStudent(String name,int idUniversity){
        Optional<University> uni = repositoryUniversity.findById(idUniversity);

        if(uni.isPresent()){
            Student stu = new Student();
            stu.setName(name);
            stu.setUniversity(uni.get());
            repositoryStudent.save(stu);
            System.out.println("Insert Student-University done correctly <===()");
        }else{
            System.out.println("There was an error");
        }
    }
}
