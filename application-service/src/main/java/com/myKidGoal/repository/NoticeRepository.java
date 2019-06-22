package com.myKidGoal.repository;

import com.myKidGoal.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "notices", path = "notices")
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    /**
     * Delete exposing false, No user can delete notice from Hal Browser
     * 
     * @param notice
     */
    @Override
    @RestResource(exported = false)
    void delete(Notice notice);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
