package com.example.practice.api_testing.controller.rest;

import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.CreateStudent;
import com.example.practice.api_testing.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Documentation with Swagger
@Tag(name = "Student API", description = "Add student and see student list")
@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    StudentService studentService;
//    @Tag(name = "Get all students", description = "Get all students")
    @GetMapping("students")
    public List<Student> getStudents() {
        return studentService.getStudents();
//        return students;
    }

//    @PostMapping("/students")
//    public Student addStudent(String name, Integer age, String gender) {
//        Student student = new Student(name, age, gender);
//        students.add(student);
//        return student;
//    }

//    @Tag(name = "Add Student", description = "Add a student to students list")
    @PostMapping("students-add")
    public Student StudentAdd(@RequestBody CreateStudent cs) {
        return studentService.StudentAdd(cs);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
