package com.myKidGoal.service;

import com.myKidGoal.TestApplication;
import com.myKidGoal.dto.AssetSummaryDto;
import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Portfolio;
import com.myKidGoal.repository.AssetRepository;
import com.myKidGoal.repository.PortfolioRepository;
import com.myKidGoal.repository.UnitRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AssetServiceTest {

    @Autowired
    private AssetService assetService;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    DataLoaderService dataLoaderService;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    UnitRepository unitRepository;

    @Before
    public void init() {
        assetRepository.deleteAll();
    }

    @Test
    public void whenSave_thenSaveIntoDatabase() {

        Set<Asset> assets = new HashSet<>();

        // save
        assets.add(new Asset(new Portfolio("House", "munawar"), "R1", "Address1", 75010, "Berlin", true, "YOC"));

        assets.add(new Asset(new Portfolio("House", "munawar"), "R2", "Address1", 75010, "Berlin", true, "YOC"));
        assetService.saveAll(assets);

        assets.clear();
        assets.add(new Asset(new Portfolio("House", "munawar"), "R2", "Address1", 75010, "Berlin", true, "YOC"));

        assetService.saveAll(assets);

        Assert.assertEquals(2, assetRepository.findAll().size());
    }

    @Test
    public void whenGetAggregateResults_thenReturnListOfAssets() throws IOException, ParseException {

        String fileName = getClass().getClassLoader().getResource("portfolio_data.csv").getPath();

        InputStream inputStream = new FileInputStream(fileName);

        String status = dataLoaderService.loadData(inputStream);

        Assert.assertEquals("Success", status);

        List<AssetSummaryDto> assetSummaryDtoList = assetService.getAssetsSummary();

        Assert.assertEquals(5, assetSummaryDtoList.size());

    }

    @Test
    public void whenGetAggregateResults_thenReturnSingleAssets() throws IOException, ParseException {

        String fileName = getClass().getClassLoader().getResource("portfolio_data.csv").getPath();

        InputStream inputStream = new FileInputStream(fileName);

        String status = dataLoaderService.loadData(inputStream);

        Assert.assertEquals("Success", status);

        AssetSummaryDto assetSummaryDto = assetService.getAssetSummary(1);

        Assert.assertEquals("Am Kupfergraben 6", assetSummaryDto.getAddress());
        Assert.assertEquals("10117", assetSummaryDto.getZipcode());
        Assert.assertEquals("Berlin", assetSummaryDto.getCity());
        Assert.assertEquals(new Integer(1876), assetSummaryDto.getYear_of_construction());
        Assert.assertEquals(true, assetSummaryDto.getRestricted_area());
        Assert.assertEquals(new Integer(6), assetSummaryDto.getNumber_of_units());
        Assert.assertEquals(new Double(7600.0), assetSummaryDto.getTotal_rent());
        Assert.assertEquals(new Integer(745), assetSummaryDto.getTotal_area());
        Assert.assertEquals(new Double(745.0), assetSummaryDto.getArea_rented());
        Assert.assertEquals(new Double(0.0), assetSummaryDto.getVacancy());
        Assert.assertEquals(new Double(0.12105263157894737), assetSummaryDto.getWalt());
    }

    @After
    public void clean() {
        unitRepository.deleteAll();
        assetRepository.deleteAll();
        portfolioRepository.deleteAll();
    }

}
