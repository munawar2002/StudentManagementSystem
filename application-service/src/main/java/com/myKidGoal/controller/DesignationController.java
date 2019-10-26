package com.myKidGoal.controller;

import com.myKidGoal.model.employee.Designation;
import com.myKidGoal.repository.employee.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/designations")
public class DesignationController {

    @Autowired
    private DesignationRepository designationRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allDepartments() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("designations", designationRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveDesignation(@RequestBody Designation designation) {
        designationRepository.save(designation);
    }

    @PutMapping("/update")
    public void updateDesignation(@RequestBody Designation designation) {
        if (designation.getId() == 0) {
            throw new EntityNotFoundException(
                    "Designation can't be updated before saving. First save the Designation and then try updating!");
        }

        designationRepository.save(designation);
    }

}
