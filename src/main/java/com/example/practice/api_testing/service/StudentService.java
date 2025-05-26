package com.example.practice.api_testing.service;

import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.CreateStudent;
import com.example.practice.api_testing.persistence.entity.StudentEntity;
import com.example.practice.api_testing.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();

        return studentEntities.stream().map(studentEntity -> {
            Long id = studentEntity.getId();
            int age = studentEntity.getAge();
            String name = studentEntity.getName();
            String gender = studentEntity.getGender();

            return new Student(id, name, age, gender);
        }).toList();
    }

    public Student StudentAdd(CreateStudent cs) {
        String name = cs.getName();
        Integer age = cs.getAge();
        String gender = cs.getGender();

        StudentEntity entity = new StudentEntity();
        entity.setName(name);
        entity.setAge(age);
        entity.setGender(gender);
//        entity.setId(1L);
        StudentEntity saved = studentRepository.save(entity);

        return new Student(saved.getId(), saved.getName(), saved.getAge(), saved.getGender());
    }
}
