package com.myKidGoal.repository.employee;

import com.myKidGoal.model.employee.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "qualifications", path = "qualifications")
public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

    /**
     * Delete exposing false, No user can delete qualification from Hal Browser
     * 
     * @param qualification
     */
    @Override
    @RestResource(exported = false)
    void delete(Qualification qualification);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
