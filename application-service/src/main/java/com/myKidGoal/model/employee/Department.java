package com.myKidGoal.model.employee;

import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_DEPARTMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {

    @Id
    @Column(name = "Id_Religion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
