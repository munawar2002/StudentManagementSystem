package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.TestInputFileLoader;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AudienceServiceTest {

    @Autowired
    AudienceService audienceService;

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
    public void studentAudienceTest() {
        Assert.assertTrue(true);
    }

}
