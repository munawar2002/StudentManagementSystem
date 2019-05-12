package com.myKidGoal.service;

import com.myKidGoal.dto.AssetSummaryDto;
import com.myKidGoal.model.Asset;

import java.util.List;
import java.util.Set;

public interface AssetService {

    /**
     * This method will save the new asset and update the existing one if user provided the same asset definition again.
     * The system assumes (Portfolio Name, Asset_Ref) will be unique. If same then system will update the existing
     * record.
     * 
     * @param assets
     *            List of assets
     */
    void saveAll(Set<Asset> assets);

    /**
     * This method will calculate all asset summary
     * 
     * @return The AssetSummaryDto
     */
    List<AssetSummaryDto> getAssetsSummary();

    /**
     * This method will calculate asset summary of single asset
     * 
     * @param assetId
     *            The Asset primary key
     * @return The AssetSummaryDto
     */
    AssetSummaryDto getAssetSummary(long assetId);

}
