package com.myKidGoal.controller;

import com.myKidGoal.model.House;
import com.myKidGoal.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/houses")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/all")
    public List<House> allHouses() {
        return houseRepository.findAll();
    }

    @PostMapping("/save")
    public void saveHouse(@RequestBody House house) {
        houseRepository.save(house);
    }

}
