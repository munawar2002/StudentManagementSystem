package com.myKidGoal.controller;

import com.myKidGoal.model.Category;
import com.myKidGoal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sms/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/search/all")
    public Map<String,Object> allCategories() {
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        res.put("category",categoryRepository.findAll());
        response.put("_embedded",res);
        return response;
    }

    @PostMapping("/save")
    public void saveCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

}
