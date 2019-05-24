package com.myKidGoal.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Objects;

/*
    The Asset table entity.
    Note: Here i didn't used the lombok library. Just to show i know both ways.
 */
@Entity
public class Asset {

    private Long id;
    private String assetRef;
    private String address;
    private int zipCode;
    private String city;
    private boolean restricted;
    private String yoc;

    public Asset() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ASSET_REF")
    public String getAssetRef() {
        return assetRef;
    }

    public void setAssetRef(String assetRef) {
        this.assetRef = assetRef;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ZIPCODE")
    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "IS_RESTRICTED")
    public boolean isRestricted() {
        return restricted;
    }

    @Basic
    @Column(name = "IS_RESTRICTED")
    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public String getYoc() {
        return yoc;
    }

    @Basic
    @Column(name = "YOC")
    public void setYoc(String yoc) {
        this.yoc = yoc;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assetRef);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
