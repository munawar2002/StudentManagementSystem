package com.myKidGoal.service;

import com.myKidGoal.dto.CategoryDto;

import java.util.List;

public interface DashboardService {

    List<CategoryDto> getStudentPerBranch();

}
