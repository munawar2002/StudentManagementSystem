package com.myKidGoal.repository;

import com.myKidGoal.model.StudentSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "studentsections", path = "studentsections")
public interface StudentSectionRepository extends JpaRepository<StudentSection, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param studentSection
     */
    @Override
    @RestResource(exported = false)
    void delete(StudentSection studentSection);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
