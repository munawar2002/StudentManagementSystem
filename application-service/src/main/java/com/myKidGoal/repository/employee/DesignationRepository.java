package com.myKidGoal.repository.employee;

import com.myKidGoal.model.employee.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "designations", path = "designations")
public interface DesignationRepository extends JpaRepository<Designation, Integer> {

    /**
     * Delete exposing false, No user can delete designation from Hal Browser
     * 
     * @param designation
     */
    @Override
    @RestResource(exported = false)
    void delete(Designation designation);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
