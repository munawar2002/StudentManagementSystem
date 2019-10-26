package com.myKidGoal.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DS_EMPLOYEEJOB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmployeeJob extends BaseTimeEntity {

    @Id
    @Column(name = "Id_EmployeeJob")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Id_Employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ID_Designation")
    private Designation designation;

    @Basic
    @Column(name = "ID_PayScale")
    private Integer payScaleId;

    @Basic
    @Column(name = "FROMDATE")
    private LocalDate fromDate;

    @Basic
    @JsonProperty("ISACTIVE")
    @Column(name = "ISACTIVE")
    private boolean active;

    @Basic
    @JsonProperty("TAXDEDUCTION")
    @Column(name = "TAXDEDUCTION")
    private boolean taxDeduction;

    @Basic
    @Column(name = "ORGANIZATION")
    private String organization;
}
