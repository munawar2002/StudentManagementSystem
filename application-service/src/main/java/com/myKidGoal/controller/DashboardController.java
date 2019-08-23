package com.myKidGoal.controller;

import com.myKidGoal.repository.StudentRepository;
import com.myKidGoal.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/dashboard")
public class DashboardController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/admin/search/all")
    public Map<String, Object> dashboardCount() {

        Map<String, Object> response = new HashMap<>();

        response.put("totalStudents", studentRepository.countByLeftSchoolIsFalse());
        response.put("currentStudents", studentRepository.countByDolIsNull());
        response.put("currentTeacher", studentRepository.countCurrentTeacher());
        response.put("studentsWithDiscount", studentRepository.countStudentDiscount());
        response.put("studentLeft", studentRepository.countStudentLeftSchool());
        response.put("studentGraduated", studentRepository.countStudentGraduated());
        response.put("studentsPerBranch", dashboardService.getStudentPerBranch());
        response.put("lastTopSixSchoolsPerBranch", dashboardService.getTopSixLastSchools());
        response.put("totalDebit", studentRepository.totalDebit());
        response.put("expensePerBranchData", dashboardService.expensePerBranchResponse());
        response.put("incomePerBranchData", dashboardService.incomePerBranchResponse());

        return response;
    }

    @GetMapping("/test")
    public void Test() {

        dashboardService.getStudentPerBranch();

    }

}
