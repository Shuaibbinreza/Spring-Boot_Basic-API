package com.example.practice.api_testing.persistence.repository;

import com.example.practice.api_testing.model.domain.Student;
import com.example.practice.api_testing.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
