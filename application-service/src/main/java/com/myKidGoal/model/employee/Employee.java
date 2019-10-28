package com.myKidGoal.model.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.myKidGoal.model.Area;
import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DS_EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity {

    @Id
    @Column(name = "Id_Employee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "Isdeleted")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "Id_Qualification")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "Id_Area")
    private Area areas;

    @Basic
    @Column(name = "ECode")
    private Integer eCode;

    @Basic
    @Column(name = "ISMALE")
    @JsonProperty("isMale")
    private Boolean male;

    @Basic
    @Column(name = "ISMARRIED")
    @JsonProperty("isMarried")
    private Boolean isMarried;

    @Basic
    @Column(name = "FATHERORHUSBAND")
    private String fatherOrHusband;

    @Basic
    @Column(name = "NICNO")
    private String nICNo;

    @Basic
    @Column(name = "NICEXPIREDON")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate nicExpiredOn;

    @Basic
    @Column(name = "CONTACT1")
    private String contact1;

    @Basic
    @Column(name = "CONTACT2")
    private String contact2;

    @Basic
    @Column(name = "ADDRESS")
    private String address;

    @Basic
    @Column(name = "BANKACCOUNT")
    private String bankAccount;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "ONPROBATION")
    @JsonProperty("onProbation")
    private Boolean onProbation;

    @Basic
    @Column(name = "DOJ")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate doj;

    @Basic
    @Column(name = "DOB")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Basic
    @Column(name = "ISLEFT")
    @JsonProperty("isLeft")
    private Boolean isLeft;

    @Basic
    @Column(name = "DOL")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dol;

    @Basic
    @Column(name = "CAUSEOFLEAVING")
    private String causeOfLeaving;

    @Basic
    @Column(name = "ISACTIVE")
    private boolean active;

    @Basic
    @Column(name = "ISTEACHER")
    @JsonProperty("isTeacher")
    private Boolean isTeacher;

}
