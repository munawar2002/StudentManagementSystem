package com.myKidGoal.repository;

import com.myKidGoal.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/*
    The Portfolio repository, contains all curd methods. *These methods are also exposed*. You can see all exposed api's to Hal browser
    For example:  /portfolios  will return all portfolios. And /portfolios/{id} will return one portfolios.
 */
@RepositoryRestResource(collectionResourceRel = "portfolios", path = "portfolios")
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    /**
     * Delete exposing false, No user can delete Asset from Hal Browser
     * 
     * @param portfolio
     */
    @Override
    @RestResource(exported = false)
    void delete(Portfolio portfolio);

    /**
     * This method will find the portfolio by given name.
     * 
     * @param name
     * @return
     */
    @RestResource(path = "byname")
    Portfolio findByName(@Param("name") String name);

}
