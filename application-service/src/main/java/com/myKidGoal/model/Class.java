package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_CLASS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class extends BaseEntity {

    @Id
    @Column(name = "Id_Class")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_Category")
    private Category category;

    @Basic
    @Column(name = "IsDeleted")
    private Boolean deleted;

    @Basic
    @Column(name = "Level")
    private Integer level;
}
