package com.myKidGoal.service;

import com.myKidGoal.model.Portfolio;
import com.myKidGoal.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    @Override
    public void saveAll(Set<Portfolio> portfolios) {

        for (Portfolio portfolio : portfolios) {

            Portfolio persistedPortfolio = portfolioRepository.findByName(portfolio.getName());

            if (persistedPortfolio != null) {
                portfolio.setId(persistedPortfolio.getId());
            }
        }

        portfolioRepository.saveAll(portfolios);

    }
}
