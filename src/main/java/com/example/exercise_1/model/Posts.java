package com.example.exercise_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String description;
    @ManyToOne
    private Category categoryName;

    public Posts(Long id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Posts() {
    }



    public Posts(String name, String author, String description) {
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category category) {
        this.categoryName = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
