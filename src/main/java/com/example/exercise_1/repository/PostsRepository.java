package com.example.exercise_1.repository;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {
    Iterable<Posts> findAllByCategory(Category category);
}
