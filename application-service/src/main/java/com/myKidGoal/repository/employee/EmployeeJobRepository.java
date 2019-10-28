package com.myKidGoal.repository.employee;

import com.myKidGoal.model.employee.Employee;
import com.myKidGoal.model.employee.EmployeeJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "employeejobs", path = "employeejobs")
public interface EmployeeJobRepository extends JpaRepository<EmployeeJob, Integer> {

    /**
     * Delete exposing false, No user can delete employeeJob from Hal Browser
     * 
     * @param employeeJob
     */
    @Override
    @RestResource(exported = false)
    void delete(EmployeeJob employeeJob);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    List<EmployeeJob> findByEmployee(Employee employee);
}
