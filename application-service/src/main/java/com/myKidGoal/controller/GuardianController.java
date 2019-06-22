package com.myKidGoal.controller;

import com.myKidGoal.model.Guardian;
import com.myKidGoal.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/guardians")
public class GuardianController {

    @Autowired
    GuardianRepository guardianRepository;

    @GetMapping("/all")
    public List<Guardian> allGuardians() {
        return guardianRepository.findAll();
    }

    @PostMapping("/save")
    public void saveGuardian(@RequestBody Guardian guardian) {
        guardianRepository.save(guardian);
    }

}
