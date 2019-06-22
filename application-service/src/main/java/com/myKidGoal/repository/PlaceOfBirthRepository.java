package com.myKidGoal.repository;

import com.myKidGoal.model.PlaceOfBirth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "placeofbirths", path = "placeofbirths")
public interface PlaceOfBirthRepository extends JpaRepository<PlaceOfBirth, Integer> {

    /**
     * Delete exposing false, No user can delete placeOfBirth from Hal Browser
     * 
     * @param placeOfBirth
     */
    @Override
    @RestResource(exported = false)
    void delete(PlaceOfBirth placeOfBirth);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
