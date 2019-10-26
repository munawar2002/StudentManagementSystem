package com.myKidGoal.model.employee;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_EMPLOYEEEXPERIENCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmployeeExperience extends BaseTimeEntity {

    @Id
    @Column(name = "ID_EmployeeExperience")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Id_Employee")
    private Employee employee;

    @Basic
    @Column(name = "WORKEDAS")
    private String workerAs;

    @Basic
    @Column(name = "DURATION")
    private String duration;

    @Basic
    @Column(name = "ORGANIZATION")
    private String organization;
}
