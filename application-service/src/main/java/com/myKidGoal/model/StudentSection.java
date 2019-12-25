package com.myKidGoal.model;

import com.myKidGoal.model.examination.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DS_STUDENTSEC")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentSection extends BaseTimeEntity {

    @Id
    @Column(name = "Id_StudentSec")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_Student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "ID_Sec")
    private Section section;

    @Basic
    @Column(name = "TransferDate")
    private Date transferDate;

    @Basic
    @Column(name = "ToDate")
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "Id_Session")
    private Session session;
}
