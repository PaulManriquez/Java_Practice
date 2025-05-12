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
    @OneToMany(mappedBy="university",fetch = FetchType.EAGER,
               cascade = CascadeType.ALL)
    private List<Student> students;
    // Controls: "When I load a University, should I also fetch its students immediately?"
    // If LAZY: Hibernate fetches students only when you call .getStudents()
    // If EAGER: Students are fetched immediately with the University

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
