package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Portfolio;
import com.myKidGoal.model.Unit;
import com.myKidGoal.repository.AssetRepository;
import com.myKidGoal.repository.PortfolioRepository;
import com.myKidGoal.repository.UnitRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UnitServiceTest {

    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private AssetRepository assetRepository;

    @Mock
    UnitRepository unitRepository;

    @InjectMocks
    UnitService unitService = new UnitServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSave_thenSaveIntoDatabase() {

        Set<Unit> units = new HashSet<>();

        Portfolio portfolio = new Portfolio("House", "munawar");
        portfolio.setId(1L);

        Mockito.when(portfolioRepository.findByName("House")).thenReturn(portfolio);

        Asset asset = new Asset(portfolio, "R1", "Address1", 75010, "Berlin", true, "YOC");
        asset.setId(2L);

        Mockito.when(assetRepository.findByPortfolioAndAssetRef(Mockito.any(), Mockito.any())).thenReturn(asset);

        Mockito.when(unitRepository.findByAssetAndUnitRef(Mockito.any(), Mockito.any())).thenReturn(null);

        // save
        units.add(new Unit(asset, "U1", 10, true, 20.0, "type", "munawar", new Date(), new Date(), new Date()));
        units.add(new Unit(asset, "U2", 10, true, 20.0, "type", "munawar", new Date(), new Date(), new Date()));

        unitService.saveAll(units);

        units.clear();

        // update
        units.add(new Unit(asset, "U2", 10, true, 20.0, "type", "munawar", new Date(), new Date(), new Date()));
        unitService.saveAll(units);

        Assert.assertEquals(0, unitRepository.findAll().size());
    }

    @After
    public void clean() {
        unitRepository.deleteAll();
        assetRepository.deleteAll();
        portfolioRepository.deleteAll();
    }
}
