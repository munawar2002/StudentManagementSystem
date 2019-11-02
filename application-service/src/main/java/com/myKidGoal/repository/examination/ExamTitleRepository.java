package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ExamTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

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

    @RestResource(path = "all")
    List<ExamTitle> findByDeletedIsFalse();

    @RestResource(path = "active")
    List<ExamTitle> findByDeletedIsFalseAndActiveIsTrue();

    /**
     * Check if not deleted exam title name exists
     *
     * @param Name
     * @return <TRUE>If exists</TRUE>
     */
    @RestResource(path = "isUnique")
    boolean existsByNameIgnoreCaseAndDeletedIsFalse(@Param("name") String Name);

    /**
     * Check if not deleted exam title name exists except given id exam title
     * 
     * @param name
     * @param id
     * @return <TRUE>If exist</TRUE>
     */
    boolean existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(@Param("name") String name, @Param("id") int id);
}
