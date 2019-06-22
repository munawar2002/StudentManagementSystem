package com.myKidGoal.repository;

import com.myKidGoal.model.LastSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "lastschools", path = "lastschools")
public interface LastSchoolRepository extends JpaRepository<LastSchool, Integer> {

    /**
     * Delete exposing false, No user can delete lastSchool from Hal Browser
     * 
     * @param lastSchool
     */
    @Override
    @RestResource(exported = false)
    void delete(LastSchool lastSchool);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
