package com.sparta.anonymousboard.example.board.service;

import com.sparta.anonymousboard.example.board.entity.Post;
import com.sparta.anonymousboard.example.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        post.setCreatedDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setPassword(null);
        }
        return post;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        posts.forEach(post -> post.setPassword(null));
        return posts;
    }

    public Post updatePost(Long id, String password, Post updatedPost) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null && existingPost.getPassword().equals(updatedPost.getPassword())) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setAuthor(updatedPost.getAuthor());
            existingPost.setContent(updatedPost.getContent());
            return postRepository.save(existingPost);
        }
        return null;
    }

    public void deletePost(Long id, String password) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null && existingPost.getPassword().equals(password)) {
            postRepository.deleteById(id);
        }
    }
}
