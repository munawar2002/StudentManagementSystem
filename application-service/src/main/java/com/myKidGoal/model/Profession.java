package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_PROFESSION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Profession extends BaseEntity {

    @Id
    @Column(name = "Id_Profession")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
