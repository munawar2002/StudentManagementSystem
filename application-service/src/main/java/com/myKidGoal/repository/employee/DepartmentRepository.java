package com.myKidGoal.repository.employee;

import com.myKidGoal.model.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "departments", path = "departments")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    /**
     * Delete exposing false, No user can delete department from Hal Browser
     * 
     * @param department
     */
    @Override
    @RestResource(exported = false)
    void delete(Department department);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
