package com.myKidGoal.controller;

import com.myKidGoal.model.Category;
import com.myKidGoal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/save")
    public void saveCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

}
