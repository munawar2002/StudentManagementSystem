package com.myKidGoal.repository.employee;

import com.myKidGoal.model.employee.Employee;
import com.myKidGoal.model.employee.EmployeeExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "empexperiences", path = "empexperiences")
public interface EmployeeExperienceRepository extends JpaRepository<EmployeeExperience, Integer> {

    /**
     * Delete exposing false, No user can delete employeeExperience from Hal Browser
     * 
     * @param employeeExperience
     */
    @Override
    @RestResource(exported = false)
    void delete(EmployeeExperience employeeExperience);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    List<EmployeeExperience> findByEmployee(Employee employee);
}
