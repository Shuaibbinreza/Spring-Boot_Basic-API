package com.example.practice.api_testing.controller;

import com.example.practice.api_testing.model.Project;
import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentRestController {
    List<Student> students = new ArrayList<>();

    @GetMapping("/api/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/api/students")
    public Student addStudent(String name, Integer age, String gender) {
        Student student = new Student(name, age, gender);
        students.add(student);
        return student;
    }

    @PostMapping("/api/students-add")
    public Student StudentAdd(@RequestBody StudentDTO studentDTO) {
        String name = studentDTO.getName();
        Integer age = studentDTO.getAge();
        String gender = studentDTO.getGender();
        Student student = new Student(name, age, gender);
        students.add(student);
        return student;
    }
}
