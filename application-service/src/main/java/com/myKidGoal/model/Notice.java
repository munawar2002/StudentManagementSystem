package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DS_NOTICE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Notice extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Notice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "Date")
    private Date date;

    @Basic
    @Column(name = "Message")
    private String message;

    @Basic
    @Column(name = "Remarks")
    private String remarks;
}
