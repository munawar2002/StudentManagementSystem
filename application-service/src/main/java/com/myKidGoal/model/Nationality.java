package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_NATIONALITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nationality extends BaseEntity {

    @Id
    @Column(name = "Id_Nationality")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
