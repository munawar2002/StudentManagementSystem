package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.SubjectTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "subjecttitles", path = "subjecttitles")
public interface SubjectTitleRepository extends JpaRepository<SubjectTitle, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param subjectTitle
     */
    @Override
    @RestResource(exported = false)
    void delete(SubjectTitle subjectTitle);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
