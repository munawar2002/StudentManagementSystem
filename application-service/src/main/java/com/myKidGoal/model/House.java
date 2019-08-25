package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_HOUSE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House extends BaseEntity {

    @Id
    @Column(name = "Id_House")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
