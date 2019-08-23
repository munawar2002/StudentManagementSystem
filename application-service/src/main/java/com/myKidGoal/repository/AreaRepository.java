package com.myKidGoal.repository;

import com.myKidGoal.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface AreaRepository extends JpaRepository<Area, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param area
     */
    @Override
    @RestResource(exported = false)
    void delete(Area area);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
