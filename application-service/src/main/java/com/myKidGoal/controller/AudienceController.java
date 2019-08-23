package com.myKidGoal.controller;

import com.myKidGoal.model.Audience;
import com.myKidGoal.repository.AudienceRepository;
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
    AudienceRepository audienceRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allAudiences() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("audiences", audienceRepository.findAll());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/save")
    public void saveClass(@RequestBody Audience audience) {
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
}
