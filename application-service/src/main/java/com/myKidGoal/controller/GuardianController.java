package com.myKidGoal.controller;

import com.myKidGoal.model.Guardian;
import com.myKidGoal.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/guardian")
public class GuardianController {

    @Autowired
    private GuardianRepository guardianRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allGuardians() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("guardian", guardianRepository.findByDeletedIsFalse());
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

    @GetMapping(value = "/isUnique/{cnic}/{id}")
    public Map<String, String> isUniqueAudienceName(@PathVariable(value = "cnic") String cnic,
            @PathVariable(value = "id") int id) {

        Boolean isAudienceExists = false;
        if (id == 0) {
            if (guardianRepository.findByCnicWithoutDash(cnic).isPresent()) {
                isAudienceExists = true;
            }
        } else {
            if (guardianRepository.findByCnicAndIdWithoutDash(cnic, id).isPresent()) {
                isAudienceExists = true;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isAudienceExists));
        return response;
    }

    @PostMapping("/save")
    public void saveGuardian(@RequestBody Guardian guardian) {
        guardianRepository.save(guardian);
    }

    @PutMapping("/update")
    public void updateGuardian(@RequestBody Guardian guardian) {
        if (guardian.getId() == 0) {
            throw new EntityNotFoundException("Guardian not found with id [0]");
        }

        guardianRepository.save(guardian);
    }

}
