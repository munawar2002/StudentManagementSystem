package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseTimeEntity;
import com.myKidGoal.model.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_SUBJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Subject")
    private Integer id;

    @JoinColumn(name = "Id_Class")
    @ManyToOne
    private Class studentClass;

    @JoinColumn(name = "Id_SubjectTitle")
    @ManyToOne
    private SubjectTitle subjectTitle;

    @Basic
    @Column(name = "IsExtraActivity")
    private boolean extraActivity;

    @Basic
    @Column(name = "IsActive")
    private boolean active;

}
