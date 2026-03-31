package com.spring.controller;

import org.springframework.web.bind.annotation.*;

import com.spring.exception.InvalidInputException;
import com.spring.exception.StudentNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable int id) {

        // Invalid input check
        if (id <= 0) {
            throw new InvalidInputException("Invalid ID! ID must be greater than 0");
        }

        // Simulated condition (only ID 1 exists)
        if (id != 1) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return "Student Found: Hemanth (ID: 1)";
    }
}