package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DS_HOUSE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House extends BaseEntity {

    @Id
    @Column(name = "Id_House")
    private Integer id;

}
