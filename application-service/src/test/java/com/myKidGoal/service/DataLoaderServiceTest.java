package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataLoaderServiceTest {

    @Autowired
    DataLoaderService dataLoaderService;

    @Test
    public void whenSaveClient_thenSaveIntoDatabase() {
        ClassLoader classLoader = getClass().getClassLoader();
        String folderPath = classLoader.getResource("Data").getPath();

        boolean success = dataLoaderService.loadData(folderPath);

        Assert.assertTrue(success);
    }

}
