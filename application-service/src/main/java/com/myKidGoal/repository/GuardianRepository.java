package com.myKidGoal.repository;

import com.myKidGoal.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "guardians", path = "guardians")
public interface GuardianRepository extends JpaRepository<Guardian, Integer> {

    /**
     * Delete exposing false, No user can delete guardian from Hal Browser
     * 
     * @param guardian
     */
    @Override
    @RestResource(exported = false)
    void delete(Guardian guardian);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Query(name = Guardian.SELECT_BY_NICNO, nativeQuery = true)
    Optional<Guardian> findByCnicWithoutDash(@Param("cnic") String cnic);

    @RestResource(path = "all")
    Optional<Guardian> findByDeletedIsFalse();

}
