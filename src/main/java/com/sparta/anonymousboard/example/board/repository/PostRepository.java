package com.sparta.anonymousboard.example.board.repository;

import com.sparta.anonymousboard.example.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

