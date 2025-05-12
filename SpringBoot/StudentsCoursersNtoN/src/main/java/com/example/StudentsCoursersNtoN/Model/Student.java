package com.example.StudentsCoursersNtoN.Model;

import jakarta.persistence.*;

import java.util.List;

// mappedBy = "courses"
// - Means this is the inverse side of the relationship.
// - The actual join table is managed by the "courses" field in Student entity.

// @ManyToMany default fetch type = LAZY
// - Collections are NOT fetched automatically.
// - You must access them within an open session or use @Transactional.
// - You can override with fetch = FetchType.EAGER if needed.


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_course",//Table N TO N
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
