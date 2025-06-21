package com.example.practice.api_testing.persistence.repository;

import com.example.practice.api_testing.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
