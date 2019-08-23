package com.myKidGoal.repository;

import com.myKidGoal.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "houses", path = "houses")
public interface HouseRepository extends JpaRepository<House, Integer> {

    /**
     * Delete exposing false, No user can delete house from Hal Browser
     * 
     * @param house
     */
    @Override
    @RestResource(exported = false)
    void delete(House house);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
