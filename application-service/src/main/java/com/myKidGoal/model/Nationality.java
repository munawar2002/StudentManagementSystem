package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_NATIONALITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Nationality extends BaseEntity {

    @Id
    @Column(name = "Id_Nationality")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
