package com.myKidGoal.model.examination;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_EXAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Exam extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Exam")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "Id_EXAMTITLE")
    @ManyToOne
    private ExamTitle examTitle;

    @Basic
    @Column(name = "Remarks")
    private String remarks;

    @Basic
    @Column(name = "SIDENOTE")
    private String sideNote;

    @JoinColumn(name = "Id_Session")
    @ManyToOne
    @JsonBackReference
    private Session session;

}
