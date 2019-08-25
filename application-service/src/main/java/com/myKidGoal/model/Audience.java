package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "AUDIENCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audience extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "ROLEID")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "BRANCHID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "CLASSID")
    private Class studentClass;

    @ManyToOne
    @JoinColumn(name = "SECTIONID")
    private Section section;

}
