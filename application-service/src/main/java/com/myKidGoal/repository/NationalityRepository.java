package com.myKidGoal.repository;

import com.myKidGoal.model.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "nationalities", path = "nationalities")
public interface NationalityRepository extends JpaRepository<Nationality, Integer> {

    /**
     * Delete exposing false, No user can delete nationality from Hal Browser
     * 
     * @param nationality
     */
    @Override
    @RestResource(exported = false)
    void delete(Nationality nationality);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
