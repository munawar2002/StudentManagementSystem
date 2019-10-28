package com.myKidGoal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_SEC")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity {

    @Id
    @Column(name = "Id_Sec")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Id_Class")
    @JsonProperty("classes")
    private Class studentClass;

    @Basic
    @Column(name = "Isdeleted")
    @JsonProperty("isDeleted")
    private Boolean deleted;
}
