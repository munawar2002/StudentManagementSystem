package com.myKidGoal.controller;

import com.myKidGoal.model.notification.Audience;
import com.myKidGoal.repository.GuardianRepository;
import com.myKidGoal.repository.StudentRepository;
import com.myKidGoal.repository.employee.EmployeeRepository;
import com.myKidGoal.repository.notification.AudienceRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/audiences")
public class AudienceController {

    @Autowired
    private AudienceRepository audienceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allAudiences() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("audiences", audienceRepository.findAudienceByDeletedIsFalseOrderByIdDesc());
        response.put("_embedded", res);
        return response;
    }

    @GetMapping("/search/active/all")
    public Map<String, Object> allActiveAudiences() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("audiences", audienceRepository.findByDeletedIsFalseAndActiveIsTrueOrderByIdDesc());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/save")
    public void saveClass(@RequestBody Audience audience) {

        if (StringUtils.isEmpty(audience.getName())) {
            throw new RuntimeException("Audience can't be saved with name [NULL]");
        }

        audienceRepository.save(audience);
    }

    @PutMapping("/update")
    public void updateAudience(@RequestBody Audience audience) {
        if (audience.getId() == 0) {
            throw new EntityNotFoundException(
                    "Audience can't be updated before saving. First save the audience and then try updating!");
        }

        audienceRepository.save(audience);
    }

    @GetMapping("/search/details/{id}")
    public Audience oneStudent(@PathVariable(value = "id") int id) {
        Optional<Audience> optionalAudience = audienceRepository.findById(id);

        if (optionalAudience.isPresent()) {
            return optionalAudience.get();
        } else {
            throw new EntityNotFoundException("Audience not found with ID [" + id + "]");
        }
    }

    @GetMapping(value = "/isUnique/{name}/{id}")
    public Map<String, String> isUniqueAudienceName(@PathVariable(value = "name") String name,
            @PathVariable(value = "id") int id) {

        boolean isAudienceNotExists;
        if (id == 0) {
            isAudienceNotExists = !audienceRepository.existsByNameIgnoreCaseAndDeletedIsFalse(name);
        } else {
            isAudienceNotExists = !audienceRepository.existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(name, id);
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isAudienceNotExists));
        return response;
    }

    @GetMapping(value = "/all/isUnique/email/{email}")
    public Map<String, String> isUniqueEmail(@PathVariable(value = "email") String email) {

        int emailCount = 0;
        if (employeeRepository.findByEmail(email).isPresent()) {
            emailCount++;
        }

        if (studentRepository.findByEmail(email).isPresent()) {
            emailCount++;
        }

        if (guardianRepository.findByEmail(email).isPresent()) {
            emailCount++;
        }

        Map<String, String> response = new HashMap<>();

        if (emailCount > 1) {
            response.put("isUnique", "false");
        } else {
            response.put("isUnique", "true");
        }

        return response;
    }

}
