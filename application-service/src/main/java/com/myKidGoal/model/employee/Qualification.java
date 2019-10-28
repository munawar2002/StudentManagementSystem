package com.myKidGoal.model.employee;

import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_QUALIFICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualification extends BaseEntity {

    @Id
    @Column(name = "Id_Qualification")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
