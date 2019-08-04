package com.myKidGoal.repository;

import com.myKidGoal.model.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "audiences", path = "audiences")
public interface AudienceRepository extends JpaRepository<Audience, Integer> {

    /**
     * Delete exposing false, No user can delete audience from Hal Browser
     * 
     * @param audience
     */
    @Override
    @RestResource(exported = false)
    void delete(Audience audience);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
