package com.example.ORM3dot1.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One University has many students
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    // Constructors
    public University() {}

    public University(String name) {
        this.name = name;
    }

    // Getter and Setter for 'students'
    public List<Student> getStudents() {
        return students;
    }

    // Bidirectional utility method
    public void addStudent(Student student) {
        students.add(student);
        student.setUniversity(this); // important for bidirectional sync
    }

    // Getters and Setters for other fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
