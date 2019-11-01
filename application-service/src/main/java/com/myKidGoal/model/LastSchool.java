package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_LASTSCHOOL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LastSchool extends BaseEntity {

    @Id
    @Column(name = "Id_LastSchool")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
