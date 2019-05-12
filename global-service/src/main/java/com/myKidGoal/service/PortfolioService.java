package com.myKidGoal.service;

import com.myKidGoal.model.Portfolio;

import java.util.Set;

public interface PortfolioService {

    /**
     * This method will save the new portfolio and update the existing one if user provided the same portfolio
     * definition again. The system assumes (Portfolio Name) will be unique. If same then system will update the
     * existing record.
     * 
     * @param portfolios
     */
    void saveAll(Set<Portfolio> portfolios);

}
