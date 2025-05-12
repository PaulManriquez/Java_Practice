package com.example.UniversityLazy.Service;

import com.example.UniversityLazy.Model.Student;
import com.example.UniversityLazy.Model.University;
import com.example.UniversityLazy.Repository.RepositoryStudent;
import com.example.UniversityLazy.Repository.RepositoryUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void displayAllStudentsWhosNameIs(String nameTosearch) {
        List<Student> studentsCoincidences = repositoryStudent.findByName(nameTosearch);

        // Check if the list is empty
        if (studentsCoincidences.isEmpty()) {
            System.out.println("No students found with the name " + nameTosearch);
        } else {
            System.out.println("Coincidences for the name: " + nameTosearch);
            for (Student ptrStudent : studentsCoincidences) {
                System.out.println(ptrStudent.getName() + " " + ptrStudent.getId());
            }
        }
    }

    public void getStudentNameAndUniversityCoincidences(String studentName,Integer idUniversity){
        List<Student> listCoincidence =  repositoryStudent.findByNameAndUniversityId(studentName,idUniversity);

        if(!listCoincidence.isEmpty()){
            System.out.println("Here you have the coincidences");
            for(Student ptrSt: listCoincidence){
                System.out.println(ptrSt.getName() + " " + idUniversity);
            }
        }else{
            System.out.println("There is no student named:" + studentName +
                    " in university with id: "+idUniversity);
        }
    }

}
