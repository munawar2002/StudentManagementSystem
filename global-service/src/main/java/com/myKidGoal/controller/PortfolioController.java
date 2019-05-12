package com.myKidGoal.controller;

import com.myKidGoal.dto.AssetSummaryDto;
import com.myKidGoal.exception.PortfolioDataLoadException;
import com.myKidGoal.service.AssetService;
import com.myKidGoal.service.DataLoaderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/*
    The class is responsible to create endpoints/api for portfolio
 */
@RestController
@BasePathAwareController
@RequestMapping({ "/portfolios" })
public class PortfolioController {

    @Autowired
    DataLoaderService dataLoaderService;

    @Autowired
    AssetService assetService;

    @ApiOperation(value = "Upload the portfolio csv (;) separated. The file will fail if file has any error. ")
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String uploadPortfolio(@RequestParam("file") MultipartFile file, HttpServletResponse response)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            return dataLoaderService.loadData(file.getInputStream());
        } catch (ParseException e) {
            throw new PortfolioDataLoadException("Unable to read Portfolio CSV. Please provide correct CSV.");
        }
    }

    @ApiOperation(value = "Get all assets aggregate results", response = AssetSummaryDto.class, responseContainer = "List")
    @GetMapping(value = "assets/all/aggregate")
    public List<AssetSummaryDto> allAssetsAggregate() throws IOException {
        return assetService.getAssetsSummary();
    }

    @ApiOperation(value = "Get aggregate results for single asset ", response = AssetSummaryDto.class)
    @GetMapping(value = "assets/{assetId}/aggregate")
    public AssetSummaryDto singleAssetAggregate(@PathVariable("assetId") long assetId) throws IOException {
        return assetService.getAssetSummary(assetId);
    }

}
