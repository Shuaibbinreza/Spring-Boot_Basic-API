package com.example.practice.api_testing.model.domain;

public class Student {
    private final Long id;
    private final String name;
    private final Integer age;
    private final String gender;

    public Student(Long id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Long getId() {
        return id;
    }
}
