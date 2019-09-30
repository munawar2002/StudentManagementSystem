package com.myKidGoal.controller;

import com.myKidGoal.model.Class;
import com.myKidGoal.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/classes")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allClasses() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("classes", classRepository.findAll());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/save")
    public void saveClass(@RequestBody Class studentClass) {
        classRepository.save(studentClass);
    }

}
