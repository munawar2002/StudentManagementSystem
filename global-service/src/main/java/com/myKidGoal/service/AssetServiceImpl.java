package com.myKidGoal.service;

import com.myKidGoal.dto.AssetSummaryDto;
import com.myKidGoal.exception.AssetNotFoundException;
import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Portfolio;
import com.myKidGoal.model.Unit;
import com.myKidGoal.repository.AssetRepository;
import com.myKidGoal.repository.PortfolioRepository;
import com.myKidGoal.repository.UnitRepository;
import com.myKidGoal.util.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    UnitRepository unitRepository;

    @Override
    public void saveAll(Set<Asset> assets) {

        for (Asset asset : assets) {

            Portfolio portfolio = portfolioRepository.findByName(asset.getPortfolio().getName());
            asset.setPortfolio(portfolio);
            Asset persistedAsset = assetRepository.findByPortfolioAndAssetRef(portfolio, asset.getAssetRef());

            if (persistedAsset != null) {
                asset.setId(persistedAsset.getId());
            }
        }

        assetRepository.saveAll(assets);
    }

    @Override
    public List<AssetSummaryDto> getAssetsSummary() {

        List<Asset> allAssets = assetRepository.findAll();

        List<AssetSummaryDto> summaryDtos = new ArrayList<>();

        for (Asset asset : allAssets) {
            summaryDtos.add(createAssetSummaryDto(asset));
        }

        return summaryDtos;
    }

    public AssetSummaryDto getAssetSummary(long assetId) {
        Optional<Asset> asset = assetRepository.findById(assetId);
        if (!asset.isPresent()) {
            throw new AssetNotFoundException("Asset not found with given id [" + assetId + "]");
        }

        return createAssetSummaryDto(asset.get());
    }

    /**
     * This method will create AssetSummaryDto object
     * 
     * @param asset
     *            The asset of whom the AssetSummaryDto will be created
     * @return
     */
    private AssetSummaryDto createAssetSummaryDto(Asset asset) {
        AssetSummaryDto summaryDto = new AssetSummaryDto();

        List<Unit> rentedUnits = asset.getUnits().stream().filter(Unit::isRented).collect(Collectors.toList());

        summaryDto.setAddress(asset.getAddress());
        summaryDto.setZipcode(String.valueOf(asset.getZipCode()));
        summaryDto.setCity(asset.getCity());
        summaryDto.setYear_of_construction(Integer.parseInt(asset.getYoc()));
        summaryDto.setRestricted_area(asset.isRestricted());
        summaryDto.setNumber_of_units(asset.getUnits().size());
        // Total Rent of Asset = Sum of all rented units of asset.
        summaryDto.setTotal_rent(rentedUnits.stream().mapToDouble(Unit::getRent).sum());

        // Total Area of Asset = Sum of Size of Units
        summaryDto.setTotal_area(asset.getUnits().stream().mapToInt(Unit::getSize).sum());

        // Area Rented of Asset = Sum of Size of all rented units
        summaryDto.setArea_rented(rentedUnits.stream().mapToDouble(Unit::getSize).sum());

        // Vacancy Percentage = (Sum of NonRented Units / Count of All Units in Asset) * 100
        long nonRentedCount = asset.getUnits().stream().filter(unit -> !unit.isRented()).count();
        summaryDto.setVacancy((nonRentedCount / summaryDto.getNumber_of_units().doubleValue()) * 100);

        // Latest Update = Max Date of (DataTimestamp)
        summaryDto.setLatest_update(asset.getUnits().stream().max(Comparator.comparing(Unit::getDataTimestamp))
                .map(Unit::getDataTimestamp).get());

        summaryDto.setWalt(findWalt(summaryDto.getTotal_rent(), rentedUnits));
        return summaryDto;
    }

    /**
     * Find walt (Weighted Average Lease Term)
     * 
     * @param totalRent
     *            Total Rent of asset
     * @param rentedUnits
     *            List of Rented Units
     * @return <double>walt</double>
     */
    @NotNull
    private Double findWalt(Double totalRent, List<Unit> rentedUnits) {

        double walt = 0.0;

        for (Unit unit : rentedUnits) {
            if (unit.isRented()) {
                double ratio = unit.getRent() / totalRent;
                int years = DateUtils.getYear(unit.getLeaseStart(), unit.getLeaseEnd());
                walt += ratio / years;
            }
        }

        return walt;
    }

}
