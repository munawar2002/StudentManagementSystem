package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ExamTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "examtitles", path = "examtitles")
public interface ExamTitleRepository extends JpaRepository<ExamTitle, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param examTitle
     */
    @Override
    @RestResource(exported = false)
    void delete(ExamTitle examTitle);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
