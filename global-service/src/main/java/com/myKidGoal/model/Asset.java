package com.myKidGoal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/*
    The Asset table entity.
    Note: Here i didn't used the lombok library. Just to show i know both ways.
 */
@Entity
@Table(name = "ASSET")
public class Asset {

    private Long id;
    private Portfolio portfolio;
    private String assetRef;
    private String address;
    private int zipCode;
    private String city;
    private boolean restricted;
    private String yoc;
    private List<Unit> units;

    public Asset() {
    }

    public Asset(Portfolio portfolio, String assetRef, String address, int zipCode, String city, boolean restricted,
            String yoc) {
        this.portfolio = portfolio;
        this.assetRef = assetRef;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.restricted = restricted;
        this.yoc = yoc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "PORTFOLIOID", nullable = false)
    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
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

    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    @OneToMany(mappedBy = "asset", fetch = FetchType.EAGER)
    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portfolio, assetRef);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
