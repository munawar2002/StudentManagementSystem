package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.TestInputFileLoader;
import com.myKidGoal.model.Guardian;
import com.myKidGoal.model.Student;
import com.myKidGoal.model.notification.Audience;
import com.myKidGoal.model.notification.Notification;
import com.myKidGoal.model.notification.NotificationDetail;
import com.myKidGoal.repository.notification.AudienceRepository;
import com.myKidGoal.repository.notification.NotificationDetailRepository;
import com.myKidGoal.service.notification.AudienceService;
import com.myKidGoal.service.notification.NotificationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AudienceServiceTest {

    @Autowired
    AudienceService audienceService;

    @Autowired
    AudienceRepository audienceRepository;

    @Autowired
    DataSource dataSource;

    @Autowired
    NotificationService notificationService;

    @Autowired
    NotificationDetailRepository notificationDetailRepository;

    @Before
    public void before() throws SQLException {
        List<String> sqlFileNames = new ArrayList();
        sqlFileNames.add("test-data/REMOVE_ALL_DATA.sql");
        sqlFileNames.add("test-data/Audience.sql");
        TestInputFileLoader.executeSQLs(sqlFileNames, dataSource);
    }

    @Test
    public void studentAudienceTest() {

        Optional<Audience> audience = audienceRepository.findById(1);
        List<Student> students = audienceService.getStudentAudience(audience.orElse(null));
        Assert.assertEquals(9, students.size());

        audience = audienceRepository.findById(2);
        students = audienceService.getStudentAudience(audience.orElse(null));
        Assert.assertEquals(5, students.size());

        audience = audienceRepository.findById(3);
        students = audienceService.getStudentAudience(audience.orElse(null));
        Assert.assertEquals(3, students.size());

        audience = audienceRepository.findById(4);
        students = audienceService.getStudentAudience(audience.orElse(null));
        Assert.assertEquals(2, students.size());
    }

    @Test
    public void studentsGuardianAudience() {

        Optional<Audience> audience = audienceRepository.findById(1);
        List<Guardian> guardians = audienceService.getStudentGuardianAudience(audience.get());
        Assert.assertEquals(9, guardians.size());

        audience = audienceRepository.findById(2);
        guardians = audienceService.getStudentGuardianAudience(audience.orElse(null));
        Assert.assertEquals(5, guardians.size());

        audience = audienceRepository.findById(3);
        guardians = audienceService.getStudentGuardianAudience(audience.orElse(null));
        Assert.assertEquals(3, guardians.size());

        audience = audienceRepository.findById(4);
        guardians = audienceService.getStudentGuardianAudience(audience.orElse(null));
        Assert.assertEquals(2, guardians.size());

    }

    @Test
    public void sendNotificationTest() {

        Optional<Audience> audience = audienceRepository.findById(2);

        Notification notification = new Notification();
        notification.setAudience(audience.orElse(null));
        notification.setEffectiveDate(LocalDateTime.now());
        notification.setExpiryDate(LocalDateTime.now());
        notification.setMessage("Sending message to students");
        notification.setPostingDate(LocalDateTime.now());
        notification.setTopic("Notification Send ExamTest");

        boolean success = notificationService.sendNotification(notification);
        Assert.assertTrue(success);

        List<NotificationDetail> notifications = notificationDetailRepository.findBySentToOrderByUserTimeDesc("2");
        Assert.assertEquals(1, notifications.size());

        notifications = notificationDetailRepository.findBySentToOrderByUserTimeDesc("42101-3357588-3");
        Assert.assertEquals(1, notifications.size());

    }

    @Test
    public void deleteNotificationTest() {

        Optional<Audience> audience = audienceRepository.findById(2);

        Notification notification = new Notification();
        notification.setAudience(audience.orElse(null));
        notification.setEffectiveDate(LocalDateTime.now());
        notification.setExpiryDate(LocalDateTime.now());
        notification.setMessage("Sending message to students");
        notification.setPostingDate(LocalDateTime.now());
        notification.setTopic("Notification Send ExamTest");

        boolean success = notificationService.sendNotification(notification);
        Assert.assertTrue(success);

        success = notificationService.deleteNotification(notification);
        Assert.assertTrue(success);

        List<NotificationDetail> notificationDetails = notificationDetailRepository.findByNotification(notification);
        Assert.assertTrue(notificationDetails.isEmpty());

    }

}
