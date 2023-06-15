package com.example.exercise_1.controller;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.model.Posts;
import com.example.exercise_1.service.category.ICategoryService;
import com.example.exercise_1.service.posts.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IPostsService postsService;

    @GetMapping
    private ResponseEntity<Iterable<Posts>> findAllPosts() {
        List<Posts> posts = (List<Posts>) postsService.findAll();
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Posts> createCategory(@RequestBody Posts posts) {
        return new ResponseEntity<>(postsService.save(posts), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> findById(@PathVariable Long id) {
        Optional<Posts> posts = postsService.findById(id);
        if (!posts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts.get(), HttpStatus.OK);
    }

    @GetMapping("{id}/search")
    public ResponseEntity<List<Posts>> findByCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id).orElse(null);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<Posts> posts = (List<Posts>) postsService.findAllByCategory(category);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

}
