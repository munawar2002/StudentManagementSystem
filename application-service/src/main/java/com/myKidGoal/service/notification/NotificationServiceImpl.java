package com.myKidGoal.service.notification;

import com.myKidGoal.exception.ApplicationException;
import com.myKidGoal.model.*;
import com.myKidGoal.model.notification.Audience;
import com.myKidGoal.model.notification.Notification;
import com.myKidGoal.model.notification.NotificationDetail;
import com.myKidGoal.repository.notification.AudienceRepository;
import com.myKidGoal.repository.notification.NotificationDetailRepository;
import com.myKidGoal.repository.notification.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private AudienceService audienceService;

    @Autowired
    private AudienceRepository audienceRepository;

    @Autowired
    private NotificationDetailRepository notificationDetailRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public boolean sendNotification(Notification notification) {

        Optional<Audience> optionalAudience = Optional.empty();
        if (notification.getAudience() != null) {
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

    @Override
    @Transactional
    public boolean deleteNotification(Notification notification) {
        notification.setDeleted(true);
        notificationRepository.save(notification);

        notificationDetailRepository.deleteByNotification(notification);
        return true;
    }

    private void sentNotificationToStudents(List<Student> students, Notification notification) {
        List<NotificationDetail> notificationDetails = new ArrayList<>();

        for (Student student : students) {
            NotificationDetail notificationDetail = new NotificationDetail();
            notificationDetail.setSentTo("" + student.getGrNo());
            notificationDetail.setNotification(notification);
            notificationDetail.setDelivered(false);
            notificationDetail.setUserTime(LocalDateTime.now());
            notificationDetails.add(notificationDetail);
        }

        notificationDetailRepository.saveAll(notificationDetails);
    }

    private void sentNotificationToGuardians(List<Guardian> guardians, Notification notification) {
        List<NotificationDetail> notificationDetails = new ArrayList<>();

        for (Guardian guardian : guardians) {
            NotificationDetail notificationDetail = new NotificationDetail();
            notificationDetail.setSentTo("" + guardian.getNicno());
            notificationDetail.setNotification(notification);
            notificationDetail.setDelivered(false);
            notificationDetail.setUserTime(LocalDateTime.now());
            notificationDetails.add(notificationDetail);
        }

        notificationDetailRepository.saveAll(notificationDetails);
    }
}
