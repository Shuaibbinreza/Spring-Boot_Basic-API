package com.example.practice.api_testing.model.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
    private String slug;
    private Boolean published;
    private LocalDateTime publishedAt;
}