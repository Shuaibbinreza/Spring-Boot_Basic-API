package com.example.practice.api_testing.controller.rest;

import com.example.practice.api_testing.exception.custom.NotFoundException;
import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.CreateStudent;
import com.example.practice.api_testing.model.dto.UpdateStudentRequest;
import com.example.practice.api_testing.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Documentation with Swagger
@Tag(name = "Student API", description = "Add student and see student list")
@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    StudentService studentService;

    @Operation(summary = "Get all the students")
    @GetMapping("students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @Operation(summary = "Add new student")
    @PostMapping("students-add")
    public Student StudentAdd(@RequestBody CreateStudent cs) {
        return studentService.StudentAdd(cs);
    }

    @Operation(summary = "Get single student by id")
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws NotFoundException {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @Operation(summary = "Update a student by id")
    @PutMapping("{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequest updateStudentRequest) throws NotFoundException {
        studentService.updateStudent(id, updateStudentRequest);
    }

    @Operation(summary = "Delete a student by id")
    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) throws NotFoundException {
        studentService.deleteStudent(id);
    }
}
