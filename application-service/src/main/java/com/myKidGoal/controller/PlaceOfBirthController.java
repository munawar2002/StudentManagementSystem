package com.myKidGoal.controller;

import com.myKidGoal.model.PlaceOfBirth;
import com.myKidGoal.repository.PlaceOfBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/placeOfBirth")
public class PlaceOfBirthController {

    @Autowired
    private PlaceOfBirthRepository placeOfBirthRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allPlaceOfBirth() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("placeOfBirth", placeOfBirthRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void savePlaceOfBirth(@RequestBody PlaceOfBirth placeOfBirth) {
        placeOfBirthRepository.save(placeOfBirth);
    }

}
