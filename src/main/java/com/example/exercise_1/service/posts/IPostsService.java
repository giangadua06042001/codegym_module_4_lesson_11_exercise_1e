package com.example.exercise_1.service.posts;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.model.Posts;
import com.example.exercise_1.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface IPostsService extends IGeneralService<Posts> {
 Iterable<Posts>findAllByCategory(Category category);
}

