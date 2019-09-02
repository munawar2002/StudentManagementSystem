package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionRepository extends JpaRepository<Session, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param session
     */
    @Override
    @RestResource(exported = false)
    void delete(Session session);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
