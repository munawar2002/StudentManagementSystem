package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ResultCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "resultCards", path = "resultCards")
public interface ResultCardRepository extends JpaRepository<ResultCard, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param resultCard
     */
    @Override
    @RestResource(exported = false)
    void delete(ResultCard resultCard);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
