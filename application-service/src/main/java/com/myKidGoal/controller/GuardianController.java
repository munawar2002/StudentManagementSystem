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

    @GetMapping(value = "/unique/cnic/{cnic}/{id}")
    public Map<String, String> isUniqueCnic(@PathVariable(value = "cnic") String cnic,
            @PathVariable(value = "id") int id) {

        Boolean isCnicExists = false;
        if (id == 0) {
            if (guardianRepository.findByCnicWithoutDash(cnic).isPresent()) {
                isCnicExists = true;
            }
        } else {
            if (guardianRepository.findByCnicAndIdWithoutDash(cnic, id).isPresent()) {
                isCnicExists = true;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(!isCnicExists));
        return response;
    }

    @GetMapping(value = "/unique/email/{email}/{id}")
    public Map<String, String> isUniqueEmail(@PathVariable(value = "email") String email,
            @PathVariable(value = "id") int id) {

        boolean isEmailExists = false;
        if (id == 0) {
            if (guardianRepository.findByEmail(email).isPresent()) {
                isEmailExists = true;
            }
        } else {
            if (guardianRepository.findByEmailAndId(email, id).isPresent()) {
                isEmailExists = true;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(!isEmailExists));
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
