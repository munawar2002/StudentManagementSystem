package com.myKidGoal.service;

import com.myKidGoal.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    AudienceService audienceService;

    @Override
    public boolean saveNotification(Notification notification) {

        // todo: changing type of sentTo to String and save grNo for student and CNIC for Parents. So that we can search
        // with it.

        return true;
    }
}
