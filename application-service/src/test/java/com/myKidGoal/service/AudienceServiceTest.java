package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.TestInputFileLoader;
import com.myKidGoal.model.Audience;
import com.myKidGoal.model.Guardian;
import com.myKidGoal.model.Student;
import com.myKidGoal.repository.AudienceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AudienceServiceTest {

    @Autowired
    AudienceService audienceService;

    @Autowired
    AudienceRepository audienceRepository;

    @Autowired
    DataSource dataSource;

    @Before
    public void before() throws SQLException {
        List<String> sqlFileNames = new ArrayList();
        sqlFileNames.add("test-data/REMOVE_ALL_DATA.sql");
        sqlFileNames.add("test-data/Audience.sql");
        TestInputFileLoader.executeSQLs(sqlFileNames, dataSource);
    }

    @Test
    public void allStudentAudienceTest() {

        Optional<Audience> allStudentsAudience = audienceRepository.findById(1);

        List<Student> students = audienceService.getStudentAudience(allStudentsAudience.get());

        Assert.assertEquals(9, students.size());
    }

    @Test
    public void class2StudentAudienceTest() {

        Optional<Audience> class2StudentsAudience = audienceRepository.findById(2);

        List<Student> students = audienceService.getStudentAudience(class2StudentsAudience.get());

        Assert.assertEquals(5, students.size());
    }

    @Test
    public void class2SecAStudentAudienceTest() {

        Optional<Audience> class2SecAStudentsAudience = audienceRepository.findById(3);

        List<Student> students = audienceService.getStudentAudience(class2SecAStudentsAudience.get());

        Assert.assertEquals(3, students.size());
    }

    @Test
    public void class3SecBStudentAudienceTest() {

        Optional<Audience> class3SecBStudentsAudience = audienceRepository.findById(4);

        List<Student> students = audienceService.getStudentAudience(class3SecBStudentsAudience.get());

        Assert.assertEquals(2, students.size());
    }

    @Test
    public void studentsGuardianAudience() {

        Optional<Audience> audience = audienceRepository.findById(1);
        List<Guardian> guardians = audienceService.getStudentGuardianAudience(audience.get());
        Assert.assertEquals(9, guardians.size());

        audience = audienceRepository.findById(2);
        guardians = audienceService.getStudentGuardianAudience(audience.get());
        Assert.assertEquals(5, guardians.size());

        audience = audienceRepository.findById(3);
        guardians = audienceService.getStudentGuardianAudience(audience.get());
        Assert.assertEquals(3, guardians.size());

        audience = audienceRepository.findById(4);
        guardians = audienceService.getStudentGuardianAudience(audience.get());
        Assert.assertEquals(2, guardians.size());

    }

}
