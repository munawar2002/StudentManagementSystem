package com.myKidGoal.repository.notification;

import com.myKidGoal.model.notification.Notification;
import com.myKidGoal.model.notification.NotificationDetail;
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
    List<NotificationDetail> findBySentToOrderByUserTimeDesc(String userId);

    List<NotificationDetail> deleteByNotification(Notification notification);

    List<NotificationDetail> findByNotification(Notification notification);

}
