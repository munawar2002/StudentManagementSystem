package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ExamTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "tests", path = "tests")
public interface ExamTestRepository extends JpaRepository<ExamTest, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     *
     * @param test
     */
    @Override
    @RestResource(exported = false)
    void delete(ExamTest test);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
