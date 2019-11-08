package com.myKidGoal.service;

import com.myKidGoal.model.enums.SessionStatus;
import com.myKidGoal.model.examination.Session;
import com.myKidGoal.repository.examination.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    @Transactional
    public Session executeSession(Session session) {
        session.setStatus(SessionStatus.ACTIVE.name());
        session.setExecuted(false);
        sessionRepository.save(session);
        return session;
    }
}
