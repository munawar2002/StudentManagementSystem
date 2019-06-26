package com.myKidGoal.controller;

import com.myKidGoal.model.Guardian;
import com.myKidGoal.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sms/guardian")
public class GuardianController {

    @Autowired
    GuardianRepository guardianRepository;

    @GetMapping("/search/all")
    public Map<String,Object> allGuardians() {
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        res.put("guardian",guardianRepository.findAll());
        response.put("_embedded",res);
        return response;
    }

    @PostMapping("/save")
    public void saveGuardian(@RequestBody Guardian guardian) {
        guardianRepository.save(guardian);
    }

}
