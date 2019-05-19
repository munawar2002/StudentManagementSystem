package com.myKidGoal.controller;

import com.myKidGoal.model.Portfolio;
import com.myKidGoal.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    PortfolioRepository portfolioRepository;

    @GetMapping("/me")
    public List<Portfolio> getMe() {
        return portfolioRepository.findAll();
    }

}
