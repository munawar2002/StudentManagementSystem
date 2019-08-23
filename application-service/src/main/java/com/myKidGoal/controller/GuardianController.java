package com.myKidGoal.controller;

import com.myKidGoal.model.Guardian;
import com.myKidGoal.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/guardian")
public class GuardianController {

    @Autowired
    GuardianRepository guardianRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allGuardians() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("guardian", guardianRepository.findAll());
        response.put("_embedded", res);
        return response;
    }

    @GetMapping("/search/details/{id}")
    public Guardian oneGuardian(@PathVariable(value = "id") int id) {
        Optional<Guardian> optionalGuardian = guardianRepository.findById(id);

        if (optionalGuardian.isPresent()) {
            return optionalGuardian.get();
        } else {
            throw new RuntimeException("Guardian not found with ID [" + id + "]");
        }
    }

    @GetMapping("/search/details/cnic/{nic}")
    public Guardian oneGuardianAgainstNIC(@PathVariable(value = "nic") String nic) {

        Optional<Guardian> optionalGuardian = guardianRepository.findByCnicWithoutDash(nic);

        if (optionalGuardian.isPresent()) {
            return optionalGuardian.get();
        } else {
            throw new RuntimeException("Guardian not found with NIC [" + nic + "]");
        }
    }

    @GetMapping("/search/details/cnic/unique/{nic}")
    public Map<String, Boolean> uniqueGuardian(@PathVariable(value = "nic") String nic) {

        Optional<Guardian> optionalGuardian = guardianRepository.findByCnicWithoutDash(nic);

        Map<String, Boolean> response = new HashMap<>();
        if (optionalGuardian.isPresent()) {
            response.put("isUnique", false);
        } else {
            response.put("isUnique", true);
        }
        return response;
    }

    @PostMapping("/save")
    public void saveGuardian(@RequestBody Guardian guardian) {
        guardianRepository.save(guardian);
    }

}
