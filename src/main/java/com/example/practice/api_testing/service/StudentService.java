package com.example.practice.api_testing.service;

import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.CreateStudent;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public Student StudentAdd(CreateStudent cs) {
        String name = cs.getName();
        Integer age = cs.getAge();
        String gender = cs.getGender();
        Student student = new Student(name, age, gender);
        students.add(student);
        return student;
    }
}
