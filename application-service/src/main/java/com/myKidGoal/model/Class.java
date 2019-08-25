package com.myKidGoal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_CLASS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Class extends BaseEntity {

    @Id
    @Column(name = "Id_Class")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Id_Category")
    private Category category;

    @Basic
    @Column(name = "Isdeleted")
    @JsonProperty("isDeleted")
    private Boolean deleted;

    @Basic
    @Column(name = "Level")
    private Integer level;
}
