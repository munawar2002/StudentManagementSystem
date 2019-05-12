package com.myKidGoal.repository;

import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/*
    The asset repository, contains all curd methods. *These methods are also exposed*. You can see all exposed api's to Hal browser
    For example:  /assets  will return all assets. And /assets/{id} will return one asset.
 */
@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")
public interface AssetRepository extends JpaRepository<Asset, Long> {

    /**
     * Delete exposing false, No user can delete Asset from Hal Browser
     * 
     * @param asset
     */
    @Override
    @RestResource(exported = false)
    void delete(Asset asset);

    /**
     * This method will find the asset with given Portfolio and Asset_Ref
     * 
     * @param portfolio
     * @param assetRef
     * @return
     */
    Asset findByPortfolioAndAssetRef(Portfolio portfolio, String assetRef);

    /**
     * Get All assets of given portfolio
     * 
     * @param portfolio
     * @return
     */
    List<Asset> findByPortfolio(Portfolio portfolio);

}
