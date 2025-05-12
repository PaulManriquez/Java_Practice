package com.example.UniversityLazy.Model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //One university belong to n students in Students entity
    //mappedBy = "university" tells Hibernate that University is not the owner of the relationship — Student is.
    //Cascade:  This means that any operation (like persist, merge, remove, etc.)
    //          performed on the parent entity (University) will be cascaded
    //          (i.e., automatically applied) to its associated child entities
    //          (Student).
    @OneToMany(mappedBy="university",fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Student> students;
    //"This university can have many students, but don't load them immediately.
    // Wait until someone actually calls .getStudents() — t
    // hen fetch them from the database."
    // When you load a University, the students list is just a placeholder (proxy).
    // If you access that list outside of a transaction, it fails (LazyInitializationException) because Hibernate no longer has a session open.
    // If you’re inside a @Transactional method, Hibernate goes: “Oh, you want the students now? Cool, let me grab them.”



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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
