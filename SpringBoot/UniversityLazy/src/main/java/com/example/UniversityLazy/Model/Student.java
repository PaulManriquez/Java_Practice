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
    // "Each student belongs to one university, but don’t load the university until someone asks for it.
    // When you load a Student, the university field is also a placeholder.
    // If you call .getUniversity() outside a transaction, boom — same LazyInitializationException.
    // But if you're inside a @Transactional method, Hibernate fetches it when needed.



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
