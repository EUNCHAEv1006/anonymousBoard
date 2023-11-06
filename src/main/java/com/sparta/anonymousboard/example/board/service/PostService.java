package com.sparta.anonymousboard.example.board.service;

import com.sparta.anonymousboard.example.board.entity.Post;
import com.sparta.anonymousboard.example.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        // Implement post creation logic, including setting createdDate
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        // Implement post retrieval logic
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPosts() {
        // Implement post retrieval logic, sorting by createdDate
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    public Post updatePost(Long id, Post updatedPost) {
        // Implement post update logic, including password validation
        return postRepository.save(updatedPost);
    }

    public void deletePost(Long id, String password) {
        // Implement post deletion logic, including password validation
        postRepository.deleteById(id);
    }
}
