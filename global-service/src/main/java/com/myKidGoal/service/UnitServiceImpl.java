package com.myKidGoal.service;

import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Portfolio;
import com.myKidGoal.model.Unit;
import com.myKidGoal.repository.AssetRepository;
import com.myKidGoal.repository.PortfolioRepository;
import com.myKidGoal.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Override
    public void saveAll(Set<Unit> units) {

        for (Unit unit : units) {

            Portfolio portfolio = portfolioRepository.findByName(unit.getAsset().getPortfolio().getName());
            Asset asset = assetRepository.findByPortfolioAndAssetRef(portfolio, unit.getAsset().getAssetRef());
            unit.setAsset(asset);
            Unit persistedUnit = unitRepository.findByAssetAndUnitRef(asset, unit.getUnitRef());

            if (persistedUnit != null) {
                unit.setId(persistedUnit.getId());
            }
        }

        unitRepository.saveAll(units);
    }
}
