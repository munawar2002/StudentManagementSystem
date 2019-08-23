package com.myKidGoal.repository;

import com.myKidGoal.model.NotificationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "notificationDetails", path = "notificationDetails")
public interface NotificationDetailRepository extends JpaRepository<NotificationDetail, Integer> {

    /**
     * Delete exposing false, No user can delete notificationDetail from Hal Browser
     * 
     * @param notificationDetail
     */
    @Override
    @RestResource(exported = false)
    void delete(NotificationDetail notificationDetail);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @RestResource(path = "userNotifications")
    List<NotificationDetail> findBySentToOrderByUserTimeDesc(int userId);
}
