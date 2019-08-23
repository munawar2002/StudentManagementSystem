package com.myKidGoal.controller;

import com.myKidGoal.service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms/dataload")
public class DataLoaderController {

    @Autowired
    DataLoaderService dataLoaderService;

    @PostMapping("/deltasoft")
    public boolean loadData(@RequestParam String folderPath) {
        return dataLoaderService.loadData(folderPath);
    }

}
