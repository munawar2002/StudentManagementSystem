package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_EXAMTYPE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamType extends BaseEntity {

    @Id
    @Column(name = "Id_ExamType")
    private Integer id;

    @Basic
    @Column(name = "Level")
    private Integer level;

}
