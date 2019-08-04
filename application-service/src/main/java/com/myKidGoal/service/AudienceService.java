package com.myKidGoal.service;

import com.global.model.User;
import com.myKidGoal.model.Audience;

import java.util.List;

public interface AudienceService {

    List<User> getAudiencePopulation(Audience audience);

}
