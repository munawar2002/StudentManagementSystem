package com.myKidGoal.repository;

import com.myKidGoal.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {

    /**
     * Delete exposing false, No user can delete profession from Hal Browser
     * 
     * @param profession
     */
    @Override
    @RestResource(exported = false)
    void delete(Profession profession);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
