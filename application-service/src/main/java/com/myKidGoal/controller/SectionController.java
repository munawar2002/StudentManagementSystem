package com.myKidGoal.controller;

import com.myKidGoal.model.Section;
import com.myKidGoal.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sms/sections")
public class SectionController {

    @Autowired
    SectionRepository sectionRepository;

    @GetMapping("/search/all")
    public Map<String,Object> allSections() {
        Map<String,Object> response = new HashMap<>();

        Map<String,Object> res = new HashMap<>();
        res.put("sec",sectionRepository.findAll());

        response.put("_embedded",res);

        return response;
    }

    @PostMapping("/save")
    public void saveSections(@RequestBody Section section) {
        sectionRepository.save(section);
    }

}
