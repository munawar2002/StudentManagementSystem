package com.myKidGoal.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "ID_USER")
    private Integer userId;

    @Basic
    @Column(name = "USERTIME")
    private Date userTime = new Date();

}
