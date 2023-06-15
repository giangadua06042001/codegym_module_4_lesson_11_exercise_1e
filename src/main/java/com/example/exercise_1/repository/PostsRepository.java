package com.example.exercise_1.repository;

import com.example.exercise_1.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
}
