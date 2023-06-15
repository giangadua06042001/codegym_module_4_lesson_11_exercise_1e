package com.example.exercise_1.service.posts;

import com.example.exercise_1.model.Category;
import com.example.exercise_1.model.Posts;
import com.example.exercise_1.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostsService implements IPostsService{
    @Autowired
    private PostsRepository postsRepository;
    @Override
    public Iterable<Posts> findAll() {
     return postsRepository.findAll();
    }

    @Override
    public Optional<Posts> findById(Long id) {
      return postsRepository.findById(id);
    }

    @Override
    public Posts save(Posts posts) {
       return postsRepository.save(posts);

    }


    @Override
    public Iterable<Posts> findAllByCategory(Category category) {
        return postsRepository.findAllByCategory(category);
    }
}
