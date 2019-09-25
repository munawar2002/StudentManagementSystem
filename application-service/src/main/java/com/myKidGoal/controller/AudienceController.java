package com.myKidGoal.controller;

import com.myKidGoal.model.notification.Audience;
import com.myKidGoal.repository.notification.AudienceRepository;
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
        res.put("audiences", audienceRepository.findAudienceByDeletedIsFalseOrderByIdDesc());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/save")
    public void saveClass(@RequestBody Audience audience) {
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

    @GetMapping(value = "/isUniqueAudienceName/{name}/{id}")
    public Map<String, String> isUniqueAudienceName(@PathVariable(value = "name") String name,
            @PathVariable(value = "id") int id) {

        Boolean isAudienceExists;
        if (id == 0) {
            isAudienceExists = !audienceRepository.existsByNameIgnoreCaseAndDeletedIsFalse(name);
        } else {
            isAudienceExists = !audienceRepository.existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(name, id);
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isAudienceExists));
        return response;
    }

}
