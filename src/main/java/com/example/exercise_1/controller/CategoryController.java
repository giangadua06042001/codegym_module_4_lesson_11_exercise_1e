package com.example.exercise_1.controller;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Iterable<Category>>findAllCategory(){
        List<Category>categories= (List<Category>) categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category>createCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category>findById(@PathVariable Long id){
        Optional<Category>category=categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

}
