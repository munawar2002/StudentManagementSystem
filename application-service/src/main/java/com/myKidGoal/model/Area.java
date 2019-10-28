package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_AREA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Area extends BaseEntity {

    @Id
    @Column(name = "Id_Area")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
