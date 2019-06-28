package com.myKidGoal.controller;

import com.myKidGoal.model.LastSchool;
import com.myKidGoal.repository.LastSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/lastschools")
public class LastSchoolController {

    @Autowired
    LastSchoolRepository lastSchoolRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allLastSchools() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("lastschool", lastSchoolRepository.findAll());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/save")
    public void saveLastSchool(@RequestBody LastSchool lastSchool) {
        lastSchoolRepository.save(lastSchool);
    }

}
