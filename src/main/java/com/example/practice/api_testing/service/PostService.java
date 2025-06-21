package com.example.practice.api_testing.service;

import com.example.practice.api_testing.model.domain.Post;
import com.example.practice.api_testing.persistence.entity.PostEntity;
import com.example.practice.api_testing.persistence.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts(Pageable pageable) {
        List<PostEntity> entityList = postRepository.findAll(pageable).getContent();
        return entityList.stream().map(entity -> {
            Post domain = new Post();
            BeanUtils.copyProperties(entity, domain);
            return domain;
        }).toList();
    }
}
