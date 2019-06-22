package com.myKidGoal.repository;

import com.myKidGoal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Delete exposing false, No user can delete category from Hal Browser
     * 
     * @param category
     */
    @Override
    @RestResource(exported = false)
    void delete(Category category);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
