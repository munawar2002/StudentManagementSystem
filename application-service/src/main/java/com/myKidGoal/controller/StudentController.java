package com.myKidGoal.controller;

import com.myKidGoal.model.Student;
import com.myKidGoal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sms/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all")
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/details/{id}")
    public Student oneStudent(@PathVariable(value = "id") int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()){
            return studentRepository.findById(id).get();
        }else {
            throw new RuntimeException("Student not found with ID ["+id+"]");
        }
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

}
