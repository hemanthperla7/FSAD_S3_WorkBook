package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.model.Course;
import com.spring.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // 1. Add Course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course c = service.addCourse(course);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    // 2. Get All Courses
    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        List<Course> list = service.getAllCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 3. Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Course c = service.getCourseById(id);

        if (c == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // 4. Update Course
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);

        if (updated == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // 5. Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        boolean deleted = service.deleteCourse(id);

        if (!deleted) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
    }
    
 // 6. Search Course by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> result = service.searchByTitle(title);

        if (result.isEmpty()) {
            return new ResponseEntity<>("No courses found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}