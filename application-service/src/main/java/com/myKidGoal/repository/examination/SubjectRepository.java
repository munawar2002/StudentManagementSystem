package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "subjects", path = "subjects")
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param subject
     */
    @Override
    @RestResource(exported = false)
    void delete(Subject subject);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
