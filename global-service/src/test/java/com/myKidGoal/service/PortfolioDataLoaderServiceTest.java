package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.repository.AssetRepository;
import com.myKidGoal.repository.PortfolioRepository;
import com.myKidGoal.repository.UnitRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PortfolioDataLoaderServiceTest {

    @Autowired
    DataLoaderService dataLoaderService;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    UnitRepository unitRepository;

    @Test
    public void whenRead_InsertData() throws IOException, ParseException {

        String fileName = getClass().getClassLoader().getResource("portfolio_data.csv").getPath();

        InputStream inputStream = new FileInputStream(fileName);

        String status = dataLoaderService.loadData(inputStream);

        Assert.assertEquals("Success", status);
    }

    @After
    public void clean() {
        unitRepository.deleteAll();
        assetRepository.deleteAll();
        portfolioRepository.deleteAll();
    }

}
