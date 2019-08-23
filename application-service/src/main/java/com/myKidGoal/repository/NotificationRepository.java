package com.myKidGoal.repository;

import com.myKidGoal.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "notifications", path = "notifications")
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    /**
     * Delete exposing false, No user can delete notifications from Hal Browser
     * 
     * @param notification
     */
    @Override
    @RestResource(exported = false)
    void delete(Notification notification);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
