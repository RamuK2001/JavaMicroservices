package com.cg.ams.service;

import com.cg.ams.entity.CourseEntity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Disabled
class CourseServiceTest {

    @Autowired
    ICourseService courseServ;

    // Add Course Entity
    @Test
    void addCourseTest() {
        CourseEntity course = new CourseEntity(93, "Python", "Python is a Programming Language");
        String s = courseServ.add(course);
        assertEquals("Course Added Successfully", s);
    }

    // Update Course Entity
    @Test
    void updateCourseTest() {
        CourseEntity course = new CourseEntity(93, "Cricket", "Cricket is a Sport");
        CourseEntity result = courseServ.update(course);
        assertEquals("Cricket", result.getName());
    }

    // Update Course Name by Id
    @Test
    void updateNameByIdTest() {
        CourseEntity course = courseServ.updateNameById(93, "Sport");
        assertEquals("Cricket is a Sport", course.getDescription());
    }

    // Delete Course Entity
    @Test
    @Disabled
    void deleteCourseTest() {
        CourseEntity course = new CourseEntity(93, "Python", "Python is a Programming Language");
        CourseEntity result = courseServ.delete(course);
        assertEquals("Python", result.getName());
        assertEquals("Python ia a Programming Language", result.getDescription());

    }

    // Get Course Entity by Name
    @Test
    void getByNameTest() {
        CourseEntity course = courseServ.findByName("Python");
        assertEquals(93, course.getId());
    }

    // Get Course Entity By Id
    @Test
    void getByIdTest() {
        CourseEntity course = courseServ.findById(93);
        assertEquals("Python", course.getName());
    }

    // Delete Course By Name
    @Test
    @Disabled
    void deleteByNameTest() {
        CourseEntity course = courseServ.deleteByName("Cricket");
        assertEquals(104, course.getId());
    }

    // Delete Course By Id
    @Test
    //@Disabled
    void deleteById() {
        CourseEntity course = courseServ.deleteById(93);
        assertEquals("Sport", course.getName());
    }

    // List All Courses
    @Test
    void getAllCoursesTest() {
        List<CourseEntity> courseList = courseServ.getAllCourses();
        assertEquals(5, courseList.size());
    }

}
