package com.example.practice.api_testing.controller.rest;

import com.example.practice.api_testing.exception.NotFoundException;
import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.CreateStudent;
import com.example.practice.api_testing.model.dto.UpdateStudentRequest;
import com.example.practice.api_testing.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student;

        try{
            student = studentService.getStudentById(id);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(student);
    }

    @Operation(summary = "Update a student by id")
    @PutMapping("{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequest updateStudentRequest) {
        Student student;

        try{
            studentService.updateStudent(id, updateStudentRequest);
        } catch (NotFoundException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete a student by id")
    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        Student student;

        try{
            studentService.deleteStudent(id);
        } catch (NotFoundException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.internalServerError().build();
        }
    }
}
