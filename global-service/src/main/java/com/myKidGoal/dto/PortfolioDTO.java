package com.myKidGoal.dto;

import lombok.Data;

/**
 * This class is created to store portfolio data (de-normalized) that user has uploaded via Portfolio csv. Note: Lombok
 * library is used. @Data will generate getters setters for us.
 */
@Data
public class PortfolioDTO {

    private String portfolio;
    private String asset_ref;
    private String asset_address;
    private String asset_zipcode;
    private String asset_city;
    private String asset_is_restricted;
    private String asset_yoc;
    private String unit_ref;
    private String unit_size;
    private String unit_is_rented;
    private String unit_rent;
    private String unit_type;
    private String unit_tenant;
    private String unit_lease_start;
    private String unit_lease_end;
    private String data_timestamp;

}
