package com.myKidGoal.model.employee;

import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_DESIGNATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Designation extends BaseEntity {

    @Id
    @Column(name = "Id_Designation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_Department")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "ID_Parent")
    private Department parent;
}
