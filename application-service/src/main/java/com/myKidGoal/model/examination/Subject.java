package com.myKidGoal.model.examination;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myKidGoal.model.BaseTimeEntity;
import com.myKidGoal.model.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_SUBJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Subject extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Subject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "Id_Class")
    @ManyToOne
    private Class classes;

    @JoinColumn(name = "ID_SUBJECTTITLE")
    @ManyToOne
    private SubjectTitle subjectTitle;

    @Basic
    @Column(name = "ISACTIVE")
    private boolean active;

    @JoinColumn(name = "Id_Session")
    @ManyToOne
    @JsonBackReference
    private Session session;

}
