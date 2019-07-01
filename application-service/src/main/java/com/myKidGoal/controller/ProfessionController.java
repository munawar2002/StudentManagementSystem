package com.myKidGoal.controller;

import com.myKidGoal.model.Profession;
import com.myKidGoal.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/profession")
public class ProfessionController {

    @Autowired
    ProfessionRepository professionRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allProfession() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("profession", professionRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveProfession(@RequestBody Profession profession) {
        professionRepository.save(profession);
    }

}
