package com.myKidGoal.controller;

import com.myKidGoal.model.examination.Session;
import com.myKidGoal.repository.examination.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/session")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allSession() {
        Map<String, Object> response = new HashMap<>();

        Map<String, Object> res = new HashMap<>();
        res.put("sessions", sessionRepository.findAll());

        response.put("_embedded", res);

        return response;
    }

    @PostMapping("/save")
    public void saveSession(@RequestBody Session session) {
        sessionRepository.save(session);
    }

    @GetMapping("/search/details/{id}")
    public Session oneSession(@PathVariable(value = "id") int id) {
        Optional<Session> optionalSession = sessionRepository.findById(id);

        if (optionalSession.isPresent()) {
            return optionalSession.get();
        } else {
            throw new EntityNotFoundException("Session not found with ID [" + id + "]");
        }
    }

    @PutMapping("/update")
    public void updateAudience(@RequestBody Session session) {
        if (session.getId() == 0) {
            throw new EntityNotFoundException(
                    "Session can't be updated before saving. First save the session and then try updating!");
        }

        Optional<Session> optionalSession = sessionRepository.findById(session.getId());

        if (optionalSession.isPresent() ) {
            session = optionalSession.get();
            if(session.isDeleted()){
                throw new RuntimeException("Deleted session ["+session.getName()+"] can't be updated.");
            }
        }

        sessionRepository.save(session);
    }

}
