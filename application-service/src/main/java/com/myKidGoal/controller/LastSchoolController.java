package com.myKidGoal.controller;

import com.myKidGoal.model.LastSchool;
import com.myKidGoal.repository.LastSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/lastschools")
public class LastSchoolController {

    @Autowired
    LastSchoolRepository lastSchoolRepository;

    @GetMapping("/all")
    public List<LastSchool> allLastSchools() {
        return lastSchoolRepository.findAll();
    }

    @PostMapping("/save")
    public void saveLastSchool(@RequestBody LastSchool lastSchool) {
        lastSchoolRepository.save(lastSchool);
    }

}
