package com.myKidGoal.repository.examination;

import com.myKidGoal.model.examination.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "examtypes", path = "examtypes")
public interface ExamTypeRepository extends JpaRepository<ExamType, Integer> {

    /**
     * Delete exposing false, No user can delete area from Hal Browser
     * 
     * @param examType
     */
    @Override
    @RestResource(exported = false)
    void delete(ExamType examType);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @RestResource(path = "all")
    List<ExamType> findByDeletedIsFalse();

    @RestResource(path = "active")
    List<ExamType> findByDeletedIsFalseAndActiveIsTrue();

    /**
     * Check if not deleted exam type name exists
     *
     * @param Name
     * @return <TRUE>If exists</TRUE>
     */
    @RestResource(path = "isUnique")
    boolean existsByNameIgnoreCaseAndDeletedIsFalse(@Param("name") String Name);

    /**
     * Check if not deleted exam type name exists except given id exam title
     * 
     * @param name
     * @param id
     * @return <TRUE>If exist</TRUE>
     */
    boolean existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(@Param("name") String name, @Param("id") int id);
}
