package com.myKidGoal.controller;

import com.myKidGoal.model.Student;
import com.myKidGoal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allStudents() {

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> res = new HashMap<>();
        res.put("students", studentRepository.findByDeletedIsFalse());

        response.put("_embedded", res);

        return response;
    }

    @GetMapping("/search/details/{id}")
    public Student oneStudent(@PathVariable(value = "id") int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new RuntimeException("Student not found with ID [" + id + "]");
        }
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        if (student.getId() == 0) {
            throw new EntityNotFoundException(
                    "Student can't be updated before saving. First save the student and then try updating!");
        }

        studentRepository.save(student);
    }

    @GetMapping(value = "/isUnique/email/{email}/{id}")
    public Map<String, String> isUniqueEmail(@PathVariable(value = "email") String email,
            @PathVariable(value = "id") int id) {

        Boolean isEmailExists = false;
        if (id == 0) {
            if (studentRepository.findByEmail(email).isPresent()) {
                isEmailExists = true;
            }
        } else {
            if (studentRepository.findByEmailAndId(email, id).isPresent()) {
                isEmailExists = true;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isEmailExists));
        return response;
    }

}
