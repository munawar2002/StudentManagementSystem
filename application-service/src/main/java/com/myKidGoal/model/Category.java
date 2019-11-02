package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    @Id
    @Column(name = "Id_Category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "Orderno")
    private Integer orderNo;

    @Basic
    @Column(name = "Bankaccount")
    private String bankAccount;

    @Basic
    @Column(name = "Short")
    private String shortAccount;

    @Basic
    @Column(name = "Code")
    private Integer code;
}
