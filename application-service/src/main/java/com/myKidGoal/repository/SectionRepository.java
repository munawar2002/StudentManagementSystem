package com.myKidGoal.repository;

import com.myKidGoal.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "sections", path = "sections")
public interface SectionRepository extends JpaRepository<Section, Integer> {

    /**
     * Delete exposing false, No user can delete section from Hal Browser
     * 
     * @param section
     */
    @Override
    @RestResource(exported = false)
    void delete(Section section);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
