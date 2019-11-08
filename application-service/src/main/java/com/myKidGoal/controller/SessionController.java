package com.myKidGoal.controller;

import com.myKidGoal.model.enums.SessionStatus;
import com.myKidGoal.model.examination.Session;
import com.myKidGoal.repository.examination.SessionRepository;
import com.myKidGoal.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/academicsession")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionService sessionService;

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
            throw new RuntimeException("Session not found with ID [" + id + "]");
        }
    }

    @PostMapping("/execute")
    public Session executeSession(@RequestBody Session sessionRequest, HttpServletResponse response) {

        Session session = sessionRepository.findByName(sessionRequest.getName());

        try {
            if (session == null
                    || session != null && session.getStatus().equalsIgnoreCase(SessionStatus.SAVED.name())) {
                session = sessionService.executeSession(session);

                response.setStatus(HttpServletResponse.SC_CREATED);
            }
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(
                    "Unable to execute session creation process, For more details check the logs" + ex);
        }
        return session;
    }

    @GetMapping("/search/all")
    public Map<String, Object> allSessions() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("academicsession", sessionRepository.findByDeletedIsFalseAndActiveIsTrue());
        response.put("_embedded", res);
        return response;
    }

    @GetMapping(value = "/isUnique/{name}/{id}")
    public Map<String, String> isUniqueSessionName(@PathVariable(value = "name") String name,
            @PathVariable(value = "id") int id) {

        Boolean isSessionExists;
        if (id == 0) {
            isSessionExists = !sessionRepository.existsByNameIgnoreCaseAndDeletedIsFalse(name);
        } else {
            isSessionExists = !sessionRepository.existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(name, id);
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isSessionExists));
        return response;
    }

    @PutMapping("/update")
    public void updateSession(@RequestBody Session session) {
        if (session.getId() == 0) {
            throw new EntityNotFoundException(
                    "Session can't be updated before saving. First save the session and then try updating!");
        }

        sessionRepository.save(session);
    }

}
