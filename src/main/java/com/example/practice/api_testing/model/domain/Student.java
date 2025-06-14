package com.example.practice.api_testing.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private Integer age;

    @Getter
    private String gender;
}
