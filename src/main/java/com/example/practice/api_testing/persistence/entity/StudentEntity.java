package com.example.practice.api_testing.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "student")
@Entity
@Getter
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String name;

    @Setter
    private Integer age;

    @Setter
    private String gender;
}
