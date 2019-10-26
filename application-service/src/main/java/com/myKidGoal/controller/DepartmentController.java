package com.myKidGoal.controller;

import com.myKidGoal.model.employee.Department;
import com.myKidGoal.repository.employee.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allDepartments() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("departments", departmentRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }

    @PostMapping("/update")
    public void updateDepartment(@RequestBody Department department) {
        if (department.getId() == 0) {
            throw new EntityNotFoundException(
                    "Department can't be updated before saving. First save the Department and then try updating!");
        }

        departmentRepository.save(department);
    }

}
