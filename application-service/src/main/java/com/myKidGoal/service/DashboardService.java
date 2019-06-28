package com.myKidGoal.service;

import com.myKidGoal.dto.CategoryDto;
import com.myKidGoal.dto.LastSchoolDto;

import java.util.List;

public interface DashboardService {

    List<CategoryDto> getStudentPerBranch();

    List<LastSchoolDto> getTopSixLastSchools();

}
