package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_EXAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Exam")
    private Integer id;

    @JoinColumn(name = "Id_ExamTitle")
    @ManyToOne
    private ExamTitle examTitle;

    @Basic
    @Column(name = "Remarks")
    private String remarks;

    @Basic
    @Column(name = "SideNote")
    private String sideNote;

    @JoinColumn(name = "Id_Session")
    @ManyToOne
    private Session sessionInfo;

}
