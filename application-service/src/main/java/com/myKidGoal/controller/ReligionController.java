package com.myKidGoal.controller;

import com.myKidGoal.model.Religion;
import com.myKidGoal.repository.ReligionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/religion")
public class ReligionController {

    @Autowired
    ReligionRepository religionRepository;

    @GetMapping("/search/all")
    public Map<String,Object> allReligion() {
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        res.put("religion",religionRepository.findAll());
        response.put("_embedded",res);
        return response;

    }

    @PostMapping("/save")
    public void saveReligion(@RequestBody Religion religion) {
        religionRepository.save(religion);
    }

}
