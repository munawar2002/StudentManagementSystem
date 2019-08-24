package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @Column(name = "Id_Category")
    private Integer id;

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
