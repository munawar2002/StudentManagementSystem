package com.myKidGoal.repository;

import com.myKidGoal.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "guardians", path = "guardians")
public interface GuardianRepository extends JpaRepository<Guardian, Integer> {

    /**
     * Delete exposing false, No user can delete guardian from Hal Browser
     * 
     * @param guardian
     */
    @Override
    @RestResource(exported = false)
    void delete(Guardian guardian);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
