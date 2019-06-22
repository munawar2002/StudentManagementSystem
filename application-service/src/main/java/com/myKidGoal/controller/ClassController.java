package com.myKidGoal.controller;

import com.myKidGoal.model.Class;
import com.myKidGoal.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/classes")
public class ClassController {

    @Autowired
    ClassRepository classRepository;

    @GetMapping("/all")
    public List<Class> allClasses() {
        return classRepository.findAll();
    }

    @PostMapping("/save")
    public void saveClass(@RequestBody Class studentClass) {
        classRepository.save(studentClass);
    }

}
