package com.example.practice.api_testing.service;

import com.example.practice.api_testing.exception.NotFoundException;
import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.model.dto.CreateStudent;
import com.example.practice.api_testing.model.dto.UpdateStudentRequest;
import com.example.practice.api_testing.persistence.entity.StudentEntity;
import com.example.practice.api_testing.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student getStudentById(Long id) throws NotFoundException {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);

        if(studentEntity.isEmpty()){
            throw new NotFoundException("Student not found");
        }

        Student student = new Student(studentEntity.get().getId(), studentEntity.get().getName(), studentEntity.get().getAge(), studentEntity.get().getGender());
        return student;
    }

    public void updateStudent(Long id, UpdateStudentRequest updateStudentRequest) throws NotFoundException {
        String gender = updateStudentRequest.getGender();
        Integer age = updateStudentRequest.getAge();

        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if(studentEntity.isEmpty()){
            throw new NotFoundException("Student Not Found");
        }

        StudentEntity entity = studentEntity.get();
        entity.setAge(age);
        entity.setGender(gender);

        studentRepository.save(entity);
    }

    public void deleteStudent(Long id) throws NotFoundException {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if(studentEntity.isEmpty()){
            throw new NotFoundException("Student Not Found");
        }
        StudentEntity studentEntity1 = studentEntity.get();
        studentRepository.deleteById(studentEntity1.getId());
//        studentRepository.deleteById(id);
    }
}
