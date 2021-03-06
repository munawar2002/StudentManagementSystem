package com.myKidGoal.model.examination;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.myKidGoal.model.BaseTimeEntity;
import com.myKidGoal.model.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DS_TEST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExamTest extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Test")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "Id_Exam")
    @JsonProperty(value = "assessments")
    @ManyToOne
    private Exam exam;

    @Basic
    @Column(name = "maxmarks")
    private Double maxMarks;

    @Basic
    @Column(name = "passingmarks")
    @JsonProperty(value = "minMarks")
    private Double passingMarks;

    @Basic
    @Column(name = "monthlytestsmarks")
    private Integer monthlyTestsMarks;

    @Basic
    @Column(name = "EXAMDATE")
    private Date examDate;

    @JoinColumn(name = "Id_Subject")
    @JsonProperty(value = "course")
    @ManyToOne
    private Subject subject;

    @JoinColumn(name = "Id_Session")
    @ManyToOne
    @JsonBackReference
    private Session session;

    @Transient
    private Class classes;

    public Class getClasses() {
        if (subject != null) {
            return subject.getClasses();
        }
        return null;
    }
}
