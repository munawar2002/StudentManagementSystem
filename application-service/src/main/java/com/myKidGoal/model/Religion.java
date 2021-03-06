package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_RELIGION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Religion extends BaseEntity {

    @Id
    @Column(name = "Id_Religion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
