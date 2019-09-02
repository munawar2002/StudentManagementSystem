package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_EXAMTITLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamTitle extends BaseEntity {

    @Id
    @Column(name = "Id_ExamTitle")
    private Integer id;

    @Basic
    @Column(name = "IsActive")
    private boolean active;

    @JoinColumn(name = "Id_ExamType")
    @ManyToOne
    private ExamType examType;

}
