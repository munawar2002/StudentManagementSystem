package com.myKidGoal.controller;

import com.myKidGoal.model.Section;
import com.myKidGoal.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/sections")
public class SectionController {

    @Autowired
    SectionRepository sectionRepository;

    @GetMapping("/all")
    public List<Section> allSections() {
        return sectionRepository.findAll();
    }

    @PostMapping("/save")
    public void saveSections(@RequestBody Section section) {
        sectionRepository.save(section);
    }

}
