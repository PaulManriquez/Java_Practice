package com.example.UniversityLazy.Model;


import jakarta.persistence.*;
/*
*   | Field                 | Fetch Type | Loaded Immediately? | Needs Open Session to Access?  |
    | --------------------- | ---------- | ------------------- | -----------------------------  |
    | `University.students` | LAZY       | ❌ No                | ✅ Yes                        |
    | `Student.university`  | LAZY       | ❌ No                | ✅ Yes                        |
* */

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;
    // Controls: "When I load a Student, should I also fetch the University it belongs to?"
    // If EAGER: University is fetched immediately when a Student is loaded
    // If LAZY: University is only fetched when .getUniversity() is called


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}
