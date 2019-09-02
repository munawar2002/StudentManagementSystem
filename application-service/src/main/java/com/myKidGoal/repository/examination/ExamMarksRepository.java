package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ExamMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "exammarks", path = "exammarks")
public interface ExamMarksRepository extends JpaRepository<ExamMarks, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     *
     * @param examMarks
     */
    @Override
    @RestResource(exported = false)
    void delete(ExamMarks examMarks);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
