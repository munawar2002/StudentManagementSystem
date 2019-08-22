package com.myKidGoal.service;

import com.myKidGoal.exception.ApplicationException;
import com.myKidGoal.model.*;
import com.myKidGoal.repository.AudienceRepository;
import com.myKidGoal.repository.NotificationDetailRepository;
import com.myKidGoal.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    AudienceService audienceService;

    @Autowired
    AudienceRepository audienceRepository;

    @Autowired
    NotificationDetailRepository notificationDetailRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public boolean sendNotification(Notification notification) {

        Optional<Audience> optionalAudience = Optional.empty();
        if (notification.getAudience() != null && notification.getAudience().getId() != null) {
            optionalAudience = audienceRepository.findById(notification.getAudience().getId());
        }

        if (!optionalAudience.isPresent()) {
            throw new ApplicationException("Audience not found with id [" + notification.getAudience().getId() + "]");
        }

        try {

            Audience audience = optionalAudience.get();

            notification.setAudience(audience);

            notificationRepository.save(notification);

            List<Student> students = audienceService.getStudentAudience(audience);
            List<Guardian> guardians = audienceService.getStudentGuardianAudience(audience);

            sentNotificationToStudents(students, notification);
            sentNotificationToGuardians(guardians, notification);

            return true;
        } catch (Exception ex) {
            throw new ApplicationException("Failed while sending notification [" + notification.getTopic() + "]");
        }
    }

    private void sentNotificationToStudents(List<Student> students, Notification notification) {
        List<NotificationDetail> notificationDetails = new ArrayList<>();

        for (Student student : students) {
            NotificationDetail notificationDetail = new NotificationDetail();
            notificationDetail.setSentTo("" + student.getGrNo());
            notificationDetail.setNotification(notification);
            notificationDetail.setDelivered(false);
            notificationDetails.add(notificationDetail);
        }

        notificationDetailRepository.saveAll(notificationDetails);
    }

    private void sentNotificationToGuardians(List<Guardian> guardians, Notification notification) {
        List<NotificationDetail> notificationDetails = new ArrayList<>();

        for (Guardian guardian : guardians) {
            NotificationDetail notificationDetail = new NotificationDetail();
            notificationDetail.setSentTo("" + guardian.getCnic());
            notificationDetail.setNotification(notification);
            notificationDetail.setDelivered(false);
            notificationDetails.add(notificationDetail);
        }

        notificationDetailRepository.saveAll(notificationDetails);
    }
}
