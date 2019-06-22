package com.myKidGoal.controller;

import com.myKidGoal.model.Student;
import com.myKidGoal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all")
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

}
