package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.model.Portfolio;
import com.myKidGoal.repository.PortfolioRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PortfolioServiceTest {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Before
    public void init() {
        portfolioRepository.deleteAll();
    }

    @Test
    public void whenSave_thenSaveIntoDatabase() {

        Set<Portfolio> portfolios = new HashSet<>();

        // save
        portfolios.add(new Portfolio("House", "munawar"));
        portfolios.add(new Portfolio("Office", "munawar"));

        portfolioService.saveAll(portfolios);

        // update
        portfolios.add(new Portfolio("House", "munawar"));
        portfolioService.saveAll(portfolios);

        Assert.assertEquals(2, portfolioRepository.findAll().size());
    }

    @After
    public void clean() {
        portfolioRepository.deleteAll();
    }
}
