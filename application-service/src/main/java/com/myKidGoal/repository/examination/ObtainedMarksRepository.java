package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ObtainedMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "obtainedmarks", path = "obtainedmarks")
public interface ObtainedMarksRepository extends JpaRepository<ObtainedMarks, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     *
     * @param examMarks
     */
    @Override
    @RestResource(exported = false)
    void delete(ObtainedMarks examMarks);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
