package com.myKidGoal.controller;

import com.myKidGoal.model.Area;
import com.myKidGoal.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/exam")
public class ExaminationController {

    @Autowired
    AreaRepository areaRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allAreas() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("areas", areaRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveArea(@RequestBody Area area) {
        areaRepository.save(area);
    }

}
