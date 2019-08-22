package com.myKidGoal.service;

import com.myKidGoal.model.Audience;
import com.myKidGoal.model.Guardian;
import com.myKidGoal.model.Student;

import java.util.List;

public interface AudienceService {

    List<Student> getStudentAudience(Audience audience);

    List<Guardian> getStudentGuardianAudience(Audience audience);

}
