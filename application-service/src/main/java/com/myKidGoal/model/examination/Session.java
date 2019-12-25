package com.myKidGoal.model.examination;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.myKidGoal.model.BaseEntity;
import com.myKidGoal.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DS_SESSIONINFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Session extends BaseEntity {

    @Id
    @Column(name = "Id_Session")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "STARTDATE")
    @JsonProperty(value = "from")
    private Date startDate;

    @Basic
    @Column(name = "ENDDATE")
    @JsonProperty(value = "to")
    private Date endDate;

    @Basic
    @Column(name = "ISEXECUTED")
    @JsonProperty("isExecuted")
    private boolean executed;

    @Basic
    @Column(name = "ISDELETED")
    private boolean deleted;

    @Basic
    @Column(name = "ISACTIVE")
    private boolean active;

    @Basic
    @Column(name = "STATUS")
    private String status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinTable(name = "BRANCH_SESSION", joinColumns = { @JoinColumn(name = "Id_Session") }, inverseJoinColumns = {
            @JoinColumn(name = "Id_Category") })
    private List<Category> category;

    @OneToMany(mappedBy = "session")
    @JsonProperty(value = "assessments")
    @JsonManagedReference
    private List<Exam> exams;

    @OneToMany(mappedBy = "session")
    @JsonProperty(value = "courses")
    @JsonManagedReference
    private List<Subject> subjects;

    @OneToMany(mappedBy = "session")
    @JsonProperty(value = "assessmentschedules")
    @JsonManagedReference
    private List<ExamTest> tests;

}
