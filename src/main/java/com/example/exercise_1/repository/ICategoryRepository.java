package com.example.exercise_1.repository;

import com.example.exercise_1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category ,Long> {
}
