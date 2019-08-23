package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DS_NOTICE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice extends BaseTimeEntity {

    @Id
    @Column(name = "Id_Notice")
    private Integer id;

    @Basic
    @Column(name = "Date")
    private LocalDate date;

    @Basic
    @Column(name = "Message")
    private String message;

    @Basic
    @Column(name = "Remarks")
    private String remarks;
}
