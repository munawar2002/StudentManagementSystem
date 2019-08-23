package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DS_RELIGION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Religion extends BaseEntity {

    @Id
    @Column(name = "Id_Religion")
    private Integer id;

}
