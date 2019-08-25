package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_LASTSCHOOL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LastSchool extends BaseEntity {

    @Id
    @Column(name = "Id_LastSchool")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
