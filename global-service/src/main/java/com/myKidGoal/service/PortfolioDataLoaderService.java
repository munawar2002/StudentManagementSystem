package com.myKidGoal.service;

import com.myKidGoal.dto.PortfolioDTO;
import com.myKidGoal.exception.PortfolioDataLoadException;
import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Portfolio;
import com.myKidGoal.model.Unit;
import com.myKidGoal.util.CsvUtils;
import com.myKidGoal.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Portfolio Data Loader Service to load portfolio data csv and also save data into respected tables.
 */
@Service
public class PortfolioDataLoaderService implements DataLoaderService {

    private final static String DATE_FORMAT = "dd.mm.yy";

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    AssetService assetService;

    @Autowired
    UnitService unitService;

    @Override
    public String loadData(InputStream inputStream) throws IOException, ParseException {

        List<PortfolioDTO> portfolioDtos = CsvUtils.read(PortfolioDTO.class, inputStream);

        validate(portfolioDtos);

        Set<Portfolio> portfolios = new HashSet<>();
        Set<Asset> assets = new HashSet<>();
        Set<Unit> units = new HashSet<>();
        int line = 2; // starting from 2 because line 1 is header.
        for (PortfolioDTO portfolioDTO : portfolioDtos) {

            // creating portfolio object
            Portfolio portfolio = new Portfolio();
            portfolio.setName(portfolioDTO.getPortfolio());
            portfolio.setCrtdBy("munawar"); // userId

            // creating asset object
            Asset asset = new Asset();
            asset.setPortfolio(portfolio);
            asset.setAssetRef(portfolioDTO.getAsset_ref());
            asset.setAddress(portfolioDTO.getAsset_address());
            asset.setCity(portfolioDTO.getAsset_city());
            asset.setRestricted(portfolioDTO.getAsset_is_restricted().equalsIgnoreCase("TRUE"));
            asset.setYoc(portfolioDTO.getAsset_yoc());

            if (!StringUtils.isEmpty(portfolioDTO.getAsset_zipcode())) {
                asset.setZipCode(Integer.parseInt(portfolioDTO.getAsset_zipcode()));
            }

            // creating unit object.
            Unit unit = new Unit();
            unit.setAsset(asset);
            unit.setLeaseEnd(DateUtils.getDate(portfolioDTO.getUnit_lease_end(), DATE_FORMAT));
            unit.setLeaseStart(DateUtils.getDate(portfolioDTO.getUnit_lease_start(), DATE_FORMAT));

            if (!StringUtils.isEmpty(portfolioDTO.getUnit_rent())) {
                unit.setRent(Double.parseDouble(portfolioDTO.getUnit_rent()));
            }

            unit.setRented(portfolioDTO.getUnit_is_rented().equalsIgnoreCase("TRUE"));

            if (!StringUtils.isEmpty(portfolioDTO.getUnit_size())) {
                unit.setSize(Integer.parseInt(portfolioDTO.getUnit_size()));
            }

            unit.setTenant(portfolioDTO.getUnit_tenant());
            unit.setType(portfolioDTO.getUnit_type());
            unit.setUnitRef(portfolioDTO.getUnit_ref());
            unit.setDataTimestamp(DateUtils.getDate(portfolioDTO.getData_timestamp(), DATE_FORMAT));

            /*
             * check if user has given (PortfolioName, Asset_Ref, Unit_Ref) duplicate in file. If yes then fail the
             * portfolio file. Second option was to ignore the first record and consider the last one. But i preferred
             * to fail the file so that user should know he provided the incorrect data.
             */
            boolean isPresent = units.stream()
                    .anyMatch(u -> u.getUnitRef().equalsIgnoreCase(portfolioDTO.getUnit_ref())
                            && u.getAsset().getAssetRef().equalsIgnoreCase(portfolioDTO.getAsset_ref())
                            && unit.getAsset().getPortfolio().getName().equalsIgnoreCase(portfolioDTO.getPortfolio()));

            if (isPresent) {
                throw new PortfolioDataLoadException(
                        "Portfolio data loader failed. There is duplication in your CSV. Portfolio ["
                                + asset.getPortfolio().getName() + "] , Asset [" + unit.getAsset().getAssetRef()
                                + "] and Unit Ref [" + unit.getUnitRef()
                                + "] already exist. Please provide different Unit Ref mapping in your CSV line number ["
                                + line + "]");
            }

            portfolios.add(portfolio);
            assets.add(asset);
            units.add(unit);
            line++;
        }

        portfolioService.saveAll(portfolios);
        assetService.saveAll(assets);
        unitService.saveAll(units);

        // For failure, the exception will occur and ControllerAdvice will handle it.
        return "Success";
    }

    /**
     * All validation checks will go here.
     * 
     * @param portfolioDtos
     */
    private void validate(List<PortfolioDTO> portfolioDtos) {
        boolean invalidData = portfolioDtos.stream().filter(p -> p.getUnit_is_rented().equalsIgnoreCase("TRUE"))
                .anyMatch(p -> p.getUnit_lease_end() == null || p.getUnit_lease_start() == null);

        if (invalidData) {
            throw new PortfolioDataLoadException(
                    "Portfolio data loader failed. UnitLeaseStart and UnitLeaseEnd can not be null. Please correct the data and upload again.");
        }
    }
}
