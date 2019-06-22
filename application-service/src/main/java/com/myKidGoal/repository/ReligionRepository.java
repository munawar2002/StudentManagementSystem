package com.myKidGoal.repository;

import com.myKidGoal.model.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "religions", path = "religions")
public interface ReligionRepository extends JpaRepository<Religion, Integer> {

    /**
     * Delete exposing false, No user can delete religion from Hal Browser
     * 
     * @param religion
     */
    @Override
    @RestResource(exported = false)
    void delete(Religion religion);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
