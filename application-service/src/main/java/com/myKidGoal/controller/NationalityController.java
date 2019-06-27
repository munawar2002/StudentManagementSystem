package com.myKidGoal.controller;

import com.myKidGoal.model.Nationality;
import com.myKidGoal.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/nationality")
public class NationalityController {

    @Autowired
    NationalityRepository nationalityRepository;

    @GetMapping("/search/all")
    public Map<String,Object> allNationality() {
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        res.put("nationality",nationalityRepository.findAll());
        response.put("_embedded",res);
        return response;

    }

    @PostMapping("/save")
    public void saveNationality(@RequestBody Nationality nationality) {
        nationalityRepository.save(nationality);
    }

}
