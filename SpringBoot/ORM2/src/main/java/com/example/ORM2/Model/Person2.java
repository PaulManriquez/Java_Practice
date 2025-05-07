package com.example.ORM2.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person2")
public class Person2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for MySQL
    private Integer id;

    private String name;

    private Integer age;

    //Exists only in the Java class (Person2), not as a physical column in the post table.
    //The relationship is managed by the post table through its person2_id foreign key.
    @OneToMany(mappedBy = "person2", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
    //=====================================================================================

    // Getters and setters

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}