package com.myKidGoal.repository;

import com.myKidGoal.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassRepository extends JpaRepository<Class, Integer> {

    /**
     * Delete exposing false, No user can delete studentClass from Hal Browser
     * 
     * @param studentClass
     */
    @Override
    @RestResource(exported = false)
    void delete(Class studentClass);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
