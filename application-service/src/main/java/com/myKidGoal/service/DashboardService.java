package com.myKidGoal.service;

import com.myKidGoal.dto.CategoryDto;
import com.myKidGoal.dto.IncomeExpenseDto;
import com.myKidGoal.dto.LastSchoolDto;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    List<CategoryDto> getStudentPerBranch();

    List<LastSchoolDto> getTopSixLastSchools();

    List<IncomeExpenseDto> getCreditDebitPerBranch(String columnName);

    Map<String, Object> expensePerBranchResponse();

    Map<String, Object> incomePerBranchResponse();

}
