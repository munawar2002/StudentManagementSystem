package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseTimeEntity;
import com.myKidGoal.model.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_SUBJECTTITLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubjectTitle extends BaseTimeEntity {

    @Id
    @Column(name = "Id_SubjectTitle")
    private Integer id;

    @JoinColumn(name = "Id_Class")
    @ManyToOne
    private Class studentClass;

    @Basic
    @Column(name = "Title")
    private String title;

    @Basic
    @Column(name = "Short")
    private String shortTitle;

    @Basic
    @Column(name = "Color")
    private Integer color;

}
