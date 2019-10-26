package com.myKidGoal.repository.employee;

import com.myKidGoal.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Delete exposing false, No user can delete employee from Hal Browser
     * 
     * @param employee
     */
    @Override
    @RestResource(exported = false)
    void delete(Employee employee);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @RestResource(path = "all")
    List<Employee> findByDeletedIsFalse();

    Optional<Employee> findByEmail(@Param("email") String email);

    Optional<Employee> findByEmailAndId(@Param("email") String email, @Param("id") int id);
}
