package com.sparta.anonymousboard.example.board.controller;

import com.sparta.anonymousboard.example.board.entity.Post;
import com.sparta.anonymousboard.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/post/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestParam String password, @RequestBody Post post) {
        return postService.updatePost(postId, password, post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id, @RequestParam String password) {
        postService.deletePost(id, password);
    }
}
