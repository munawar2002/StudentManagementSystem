package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DS_TEST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Test")
    private Integer id;

    @JoinColumn(name = "Id_Exam")
    @ManyToOne
    private Exam exam;

    @Basic
    @Column(name = "maxmarks")
    private Double maxMarks;

    @Basic
    @Column(name = "passingmarks")
    private Double passingMarks;

    @Basic
    @Column(name = "monthlytestsmarks")
    private Integer monthlyTestsMarks;

    @Basic
    @Column(name = "Date")
    private LocalDate date;

    @JoinColumn(name = "Id_Subject")
    @ManyToOne
    private Subject subject;

}
