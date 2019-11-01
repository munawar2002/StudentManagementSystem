package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseTimeEntity;
import com.myKidGoal.model.StudentSection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_RESULTCARD")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ResultCard extends BaseTimeEntity {

    @Id
    @Column(name = "Id_ResultCard")
    private Integer id;

    @JoinColumn(name = "Id_Exam")
    @ManyToOne
    private Exam exam;

    @Basic
    @Column(name = "Remarks")
    private String remarks;

    @Basic
    @Column(name = "Rank")
    private String rank;

    @JoinColumn(name = "Id_StudentSec")
    @ManyToOne
    private StudentSection studentSection;

}
