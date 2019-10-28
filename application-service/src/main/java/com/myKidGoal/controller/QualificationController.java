package com.myKidGoal.controller;

import com.myKidGoal.model.employee.Qualification;
import com.myKidGoal.repository.employee.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amunawar on 10/26/19.
 */

@RestController
@RequestMapping("/sms/qualifications")
public class QualificationController {

    @Autowired
    private QualificationRepository qualificationRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allQualifications() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("qualifications", qualificationRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveQualification(@RequestBody Qualification qualification) {
        qualificationRepository.save(qualification);
    }

    @PostMapping("/update")
    public void updateQualification(@RequestBody Qualification qualification) {
        if (qualification.getId() == 0) {
            throw new EntityNotFoundException(
                    "Qualification can't be updated before saving. First save the qualification and then try updating!");
        }

        qualificationRepository.save(qualification);
    }

}
