package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "examtypes", path = "examtypes")
public interface ExamTypeRepository extends JpaRepository<ExamType, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param examType
     */
    @Override
    @RestResource(exported = false)
    void delete(ExamType examType);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
