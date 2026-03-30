package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.model.Course;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    // Add Course
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseList;
    }

    // Get Course by ID
    public Course getCourseById(int id) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // Update Course
    public Course updateCourse(int id, Course updatedCourse) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }
        return null;
    }

    // Delete Course
    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }
    
 // Search Course by Title
    public List<Course> searchByTitle(String title) {

        List<Course> result = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }

        return result;
    }
}