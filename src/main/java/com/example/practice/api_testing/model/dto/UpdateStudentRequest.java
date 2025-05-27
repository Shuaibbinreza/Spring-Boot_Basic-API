package com.example.practice.api_testing.model.dto;

public class UpdateStudentRequest {
    private Integer age;
    private String gender;

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
