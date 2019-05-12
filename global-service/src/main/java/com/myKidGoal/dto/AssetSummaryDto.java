package com.myKidGoal.dto;

import lombok.Data;

import java.util.Date;

/*
    The class is created to send as response for asset results aggregate api.
    Note: Lombok library is used. @Data will generate getters setters for us.
 */
@Data
public class AssetSummaryDto {

    private String address;
    private String zipcode;
    private String city;
    private Integer year_of_construction;
    private Boolean restricted_area;
    private Integer number_of_units;
    private Double total_rent;
    private Integer total_area;
    private Double area_rented;
    private Double vacancy;
    private Double walt;
    private Date latest_update;
}
