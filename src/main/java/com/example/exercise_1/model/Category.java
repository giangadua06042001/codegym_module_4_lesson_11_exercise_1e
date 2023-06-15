package com.example.exercise_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;
    private String category;
  @OneToMany(mappedBy = "category")
  @JsonIgnore
    private List<Posts> posts;

    public Category() {
    }

    public Category(Long c_id, String category, List posts) {
        this.c_id = c_id;
        this.category = category;
        this.posts = posts;
    }

    public Category(String category, List posts) {
        this.category = category;
        this.posts = posts;
    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List getPosts() {
        return posts;
    }

    public void setPosts(List posts) {
        this.posts = posts;
    }
}
