package com.myKidGoal.controller;

import com.myKidGoal.model.notification.Notification;
import com.myKidGoal.repository.notification.NotificationDetailRepository;
import com.myKidGoal.repository.notification.NotificationRepository;
import com.myKidGoal.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/notifications")
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    NotificationDetailRepository notificationDetailRepository;

    @Autowired
    NotificationService notificationService;

    @GetMapping("/search/all")
    public Map<String, Object> allNotifications() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("notifications", notificationRepository.findAll());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/send")
    public void sendNotification(@RequestBody Notification notification) {
        notificationService.sendNotification(notification);
    }

    @GetMapping("/search/details/{id}")
    public Notification oneNotification(@PathVariable(value = "id") int id) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);

        if (optionalNotification.isPresent()) {
            return optionalNotification.get();
        } else {
            throw new EntityNotFoundException("Notification not found with ID [" + id + "]");
        }
    }

    @GetMapping("/search/user/{id}")
    public Map<String, Object> allUserNotifications(@PathVariable(value = "id") String userId) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("notifications", notificationDetailRepository.findBySentToOrderByUserTimeDesc(userId));
        response.put("_embedded", res);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteNotification(@PathVariable int id) {

        Optional<Notification> optionalNotification = notificationRepository.findById(id);

        if (!optionalNotification.isPresent()) {
            throw new EntityNotFoundException("Notification not found with id [" + id + "]");
        }

        return notificationService.deleteNotification(optionalNotification.get());
    }
}
