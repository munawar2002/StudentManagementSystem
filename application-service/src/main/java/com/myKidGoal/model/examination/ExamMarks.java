package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_OBTAINEDMARKS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamMarks extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Exam")
    private Integer id;

    @JoinColumn(name = "Id_ResultCard")
    @ManyToOne
    private ResultCard resultCard;

    @JoinColumn(name = "Id_Test")
    @ManyToOne
    private Test test;

    @Basic
    @Column(name = "Marks")
    private Double marks;

    @Basic
    @Column(name = "SubMarks")
    private Double subMarks;

    @Basic
    @Column(name = "IsPromoted")
    private boolean promoted;

    @Basic
    @Column(name = "Attempted")
    private boolean attempted;

}
