package com.myKidGoal.repository.notification;

import com.myKidGoal.model.notification.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "audiences", path = "audiences")
public interface AudienceRepository extends JpaRepository<Audience, Integer> {

    /**
     * Delete exposing false, No user can delete audience from Hal Browser
     * 
     * @param audience
     */
    @Override
    @RestResource(exported = false)
    void delete(Audience audience);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    /**
     * Check if not deleted segment name exists
     * 
     * @param Name
     * @return <TRUE>If exists</TRUE>
     */
    @RestResource(path = "isUnique")
    boolean existsByNameIgnoreCaseAndDeletedIsFalse(@Param("name") String Name);

    /**
     * Check if not deleted segment name exists except given id
     * 
     * @param name
     * @param id
     * @return <TRUE>If exist</TRUE>
     */
    boolean existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(@Param("name") String name, @Param("id") int id);

    @RestResource(path = "all")
    List<Audience> findAudienceByDeletedIsFalseOrderByIdDesc();

    @RestResource(path = "active")
    List<Audience> findByDeletedIsFalseAndActiveIsTrueOrderByIdDesc();
}
