package com.example.ORM3dot1.Model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many students belong to one university
    @ManyToOne
    @JoinColumn(name = "university_id") // foreign key in student table
    private University university;

    // Constructors, getters, and setters
    public Student(){}

    public Student(String name, University university) {
        this.name = name;
        this.university = university;
    }

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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    // Getters and Setters
}
