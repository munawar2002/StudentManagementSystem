package com.myKidGoal.controller;

import com.myKidGoal.model.House;
import com.myKidGoal.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/houses")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allHouses() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("houses", houseRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveHouse(@RequestBody House house) {
        houseRepository.save(house);
    }

}
