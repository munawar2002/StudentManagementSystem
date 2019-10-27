package com.myKidGoal.model.examination;

import com.myKidGoal.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DS_SESSIONINFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session extends BaseEntity {

    @Id
    @Column(name = "Id_Session")
    private Integer id;

    @Basic
    @Column(name = "From")
    private LocalDate from;

    @Basic
    @Column(name = "To")
    private LocalDate to;

    @Basic
    @Column(name = "ISCLOSED")
    private boolean isClosed;

    @Basic
    @Column(name = "ISFINALIZED")
    private boolean isFinalized;
}
