package com.example.StudentsCoursersNtoN.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    //"mappedBy = "courses" means this side (Course.students)
    // is not responsible for managing the relationship table in the database.
    // Instead, the Student.courses field is the owning side."
    // The side with mappedBy is read-only in terms of join table changes.
    // The side without mappedBy (Student in this case) is the owning side and controls the relationship.


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
