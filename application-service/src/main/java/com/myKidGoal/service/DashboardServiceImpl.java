package com.myKidGoal.service;

import com.myKidGoal.dto.CategoryDto;
import com.myKidGoal.dto.IncomeExpenseDto;
import com.myKidGoal.dto.LastSchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Override
    public List<CategoryDto> getStudentPerBranch() {

        jdbcTemplate.setDataSource(dataSource);

        List<Map<String, Object>> categoryMapList = jdbcTemplate.queryForList(
                "SELECT ct.id_category as id,ct.name , COUNT(s.ID_STUDENT) as studentCount FROM ds_student s \n"
                        + "INNER JOIN ds_sec sec ON (s.id_sec = sec.id_sec) \n"
                        + "INNER JOIN ds_class cl ON (sec.ID_CLASS = cl.ID_CLASS) \n"
                        + "INNER JOIN ds_category ct ON (cl.ID_CATEGORY = ct.ID_CATEGORY) \n"
                        + "GROUP BY ct.id_category,ct.name ");

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Map<String, Object> category : categoryMapList) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId((Integer) category.get("id"));
            categoryDto.setBranchName((String) category.get("name"));
            categoryDto.setStudentCount((Long) category.get("studentCount"));
            categoryDtos.add(categoryDto);
        }

        return categoryDtos;
    }

    @Override
    public List<LastSchoolDto> getTopSixLastSchools() {
        jdbcTemplate.setDataSource(dataSource);

        List<Map<String, Object>> lastSchoolMapList = jdbcTemplate.queryForList(
                "SELECT stdt.id_lastschool AS id, ls.name, COUNT(stdt.id_student) AS count FROM ds_student stdt \n"
                        + "INNER JOIN ds_lastschool ls ON (stdt.id_lastschool = ls.id_lastschool) \n"
                        + "WHERE stdt.id_lastschool NOT IN (538,554,553) \n" + "GROUP BY stdt.id_lastschool, ls.name \n"
                        + "ORDER BY COUNT DESC \n" + "LIMIT 6");

        List<LastSchoolDto> lastSchoolDtos = new ArrayList<>();

        for (Map<String, Object> lastSchool : lastSchoolMapList) {
            LastSchoolDto lastSchoolDto = new LastSchoolDto();
            lastSchoolDto.setId((Integer) lastSchool.get("id"));
            lastSchoolDto.setSchoolName((String) lastSchool.get("name"));
            lastSchoolDto.setCount((Long) lastSchool.get("count"));
            lastSchoolDtos.add(lastSchoolDto);
        }

        return lastSchoolDtos;
    }

    @Override
    public List<IncomeExpenseDto> getCreditDebitPerBranch(String columnName) {
        jdbcTemplate.setDataSource(dataSource);

        List<Map<String, Object>> debitMapList = jdbcTemplate.queryForList(
                "SELECT cat.id_category, cat.name, SUM(sfl." + columnName + ") sum  FROM ds_v_slipfeeledger sfl \n"
                        + "INNER JOIN ds_student st ON (sfl.id_student = st.id_student) \n"
                        + "LEFT JOIN ds_sec sec ON (st.Id_Sec = sec.Id_sec) \n"
                        + "INNER JOIN ds_class c ON (sec.id_class = c.id_class) \n"
                        + "INNER JOIN ds_category cat ON (c.id_category = cat.id_category) \n"
                        + "GROUP BY cat.id_category, cat.name");

        List<IncomeExpenseDto> incomeExpenseDtos = new ArrayList<>();

        for (Map<String, Object> debit : debitMapList) {
            IncomeExpenseDto incomeExpenseDto = new IncomeExpenseDto();
            incomeExpenseDto.setLabel((String) debit.get("name"));
            List<Double> debitsList = new ArrayList<>();
            debitsList.add((Double) debit.get("sum"));
            incomeExpenseDto.setData(debitsList);
            incomeExpenseDtos.add(incomeExpenseDto);
        }

        return incomeExpenseDtos;
    }

    @Override
    public Map<String, Object> expensePerBranchResponse() {

        Map<String, Object> response = new HashMap<>();

        List<String> quarters = new ArrayList<>();
        quarters.add("Overall");

        response.put("datasets", getCreditDebitPerBranch("debit"));
        response.put("labels", quarters);
        return response;
    }

    @Override
    public Map<String, Object> incomePerBranchResponse() {
        Map<String, Object> response = new HashMap<>();

        List<String> quarters = new ArrayList<>();
        quarters.add("Overall");

        response.put("datasets", getCreditDebitPerBranch("credit"));
        response.put("labels", quarters);
        return response;
    }
}
