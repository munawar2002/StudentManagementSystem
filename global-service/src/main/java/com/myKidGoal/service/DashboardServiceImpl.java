package com.myKidGoal.service;

import com.myKidGoal.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
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
}
