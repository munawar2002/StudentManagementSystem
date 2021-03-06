package com.myKidGoal.service.notification;

import com.myKidGoal.model.notification.Audience;
import com.myKidGoal.model.Guardian;
import com.myKidGoal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class AudienceServiceImpl implements AudienceService {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Student> getStudentAudience(Audience audience) {
        String query = "SELECT stdt.* FROM ds_student stdt \n"
                + "INNER JOIN ds_sec sec ON (stdt.id_sec = sec.id_sec) \n"
                + "INNER JOIN ds_class cls ON (sec.id_class = cls.id_class) \n"
                + "INNER JOIN ds_category branch ON (cls.id_category=branch.id_category) \n" + "WHERE 1=1 \n";

        query += setQueryParameters(audience);

        List<Student> students;

        JdbcTemplate template = new JdbcTemplate(dataSource);

        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        students = template.query(query, rowMapper);
        return students;
    }

    @Override
    public List<Guardian> getStudentGuardianAudience(Audience audience) {
        String query = "SELECT guardian.* FROM ds_guardian guardian \n" + "INNER JOIN ( \n"
                + "SELECT stdt.id_parent FROM ds_student stdt \n"
                + "INNER JOIN ds_sec sec ON (stdt.id_sec = sec.id_sec) \n"
                + "INNER JOIN ds_class cls ON (sec.id_class = cls.id_class) \n"
                + "INNER JOIN ds_category branch ON (cls.id_category=branch.id_category) \n" + "WHERE 1=1 \n";

        query += setQueryParameters(audience);

        query += ") students \n" + "ON students.id_parent = guardian.id_guardian ";

        JdbcTemplate template = new JdbcTemplate(dataSource);

        RowMapper<Guardian> rowMapper = new BeanPropertyRowMapper<>(Guardian.class);
        return template.query(query, rowMapper);
    }

    private String setQueryParameters(Audience audience) {
        String query = "";
        if (audience.getCategory() != null) {
            query += "AND branch.id_category= " + audience.getCategory().getId() + " \n";
        }

        if (audience.getStudentClass() != null) {
            query += "AND cls.id_class= " + audience.getStudentClass().getId() + " \n";
        }

        if (audience.getSection() != null) {
            query += "AND sec.id_sec= " + audience.getSection().getId() + " \n";
        }
        return query;
    }

}
