package com.myKidGoal.repository;

import com.myKidGoal.model.Asset;
import com.myKidGoal.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/*
    The Unit repository, contains all curd methods. *These methods are also exposed*. You can see all exposed api's to Hal browser
    For example:  /units  will return all portfolios. And /units/{id} will return one units.
 */
@RepositoryRestResource(collectionResourceRel = "units", path = "units")
public interface UnitRepository extends JpaRepository<Unit, Long> {

    /**
     * Delete exposing false, No user can delete Asset from Hal Browser
     * 
     * @param unit
     */
    @Override
    @RestResource(exported = false)
    void delete(Unit unit);

    /**
     * This method will find unit by given asset and unit_ref
     * 
     * @param asset
     * @param unitRef
     * @return
     */
    Unit findByAssetAndUnitRef(Asset asset, String unitRef);

}
