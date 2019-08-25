package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_PLACEOFBIRTH")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOfBirth extends BaseEntity {

    @Id
    @Column(name = "Id_PlaceOfBirth")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
