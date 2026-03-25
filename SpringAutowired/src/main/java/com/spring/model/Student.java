package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component   // Makes Student a Spring Bean
public class Student {

    private int id;
    private String name;
    private String gender;

    // Dependency
    @Autowired
    private Certification certification;

    public Student() {
        this.id = 101;
        this.name = "Hemanth";
        this.gender = "Male";
    }

    public void display() {

        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);

        System.out.println("---- Certification Details ----");
        certification.display();
    }
}