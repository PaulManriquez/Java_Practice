package com.example.ORM3dot1.Service;

import com.example.ORM3dot1.Model.Student;
import com.example.ORM3dot1.Model.University;
import com.example.ORM3dot1.Repository.RepositoryStudent;
import com.example.ORM3dot1.Repository.RepositoryUniveristy;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversityService {

    public static UniversityService UniversityService;
    private final RepositoryStudent studentRepo;
    private final RepositoryUniveristy universityRepo;

    public UniversityService(RepositoryStudent studentRepo, RepositoryUniveristy universityRepo) {
        this.studentRepo = studentRepo;
        this.universityRepo = universityRepo;
    }

    @Transactional
    public void linkStudentToUniversity(int studentId, int universityId) {
        Optional<Student> optStudent = studentRepo.findById(studentId);
        Optional<University> optUniversity = universityRepo.findById(universityId);

        if (optStudent.isPresent() && optUniversity.isPresent()) {
            Student student = optStudent.get();
            University university = optUniversity.get();

            university.addStudent(student); // adds to list and sets reverse link

            universityRepo.save(university);

            System.out.println("Linked student " + student.getName() + " to university " + university.getName());
        } else {
            System.out.println("Student or University not found");
        }
    }
}
