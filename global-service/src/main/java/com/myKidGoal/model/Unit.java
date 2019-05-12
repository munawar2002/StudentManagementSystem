package com.myKidGoal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/*
    The Unit table entity.
    Note: Here i didn't used the lombok library. Just to show i know both ways.
 */
@Entity
@Table(name = "UNIT")
public class Unit {

    private Long id;
    private Asset asset;
    private String unitRef;
    private Integer size;
    private boolean rented;
    private Double rent;
    private String type;
    private String tenant;
    private Date leaseStart;
    private Date leaseEnd;
    private Date dataTimestamp;

    public Unit() {
    }

    public Unit(Asset asset, String unitRef, Integer size, boolean rented, Double rent, String type, String tenant,
            Date leaseStart, Date leaseEnd, Date dataTimestamp) {
        this.asset = asset;
        this.unitRef = unitRef;
        this.size = size;
        this.rented = rented;
        this.rent = rent;
        this.type = type;
        this.tenant = tenant;
        this.leaseStart = leaseStart;
        this.leaseEnd = leaseEnd;
        this.dataTimestamp = dataTimestamp;
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
    @JoinColumn(name = "ASSETID", nullable = false)
    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Basic
    @Column(name = "UNIT_REF")
    public String getUnitRef() {
        return unitRef;
    }

    public void setUnitRef(String unitRef) {
        this.unitRef = unitRef;
    }

    @Basic
    @Column(name = "SIZE")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "IS_RENTED")
    public boolean isRented() {
        return rented;
    }

    @Basic
    @Column(name = "IS_RENTED")
    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Basic
    @Column(name = "DATA_TIMESTAMP")
    public Date getDataTimestamp() {
        return dataTimestamp;
    }

    public void setDataTimestamp(Date dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
    }

    @Basic
    @Column(name = "RENT")
    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "TENANT")
    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @Basic
    @Column(name = "LEASE_START")
    public Date getLeaseStart() {
        return leaseStart;
    }

    public void setLeaseStart(Date leaseStart) {
        this.leaseStart = leaseStart;
    }

    @Basic
    @Column(name = "LEASE_END")
    public Date getLeaseEnd() {
        return leaseEnd;
    }

    public void setLeaseEnd(Date leaseEnd) {
        this.leaseEnd = leaseEnd;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asset, unitRef);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
