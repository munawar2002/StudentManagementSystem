package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "exams", path = "exams")
public interface ExamRepository extends JpaRepository<Exam, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param exam
     */
    @Override
    @RestResource(exported = false)
    void delete(Exam exam);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
