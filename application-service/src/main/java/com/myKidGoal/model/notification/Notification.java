package com.myKidGoal.model.notification;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NOTIFICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification extends BaseTimeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "TOPIC")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "AUDIENCEID")
    private Audience audience;

    @Basic
    @Column(name = "MESSAGE")
    private String message;

    @Basic
    @Column(name = "POSTINGDATE")
    private LocalDate postingDate;

    @Basic
    @Column(name = "EFFECTIVEDATE")
    private LocalDate effectiveDate;

    @Basic
    @Column(name = "EXPIRYDATE")
    private LocalDate expiryDate;

    @Basic
    @Column(name = "ISDELETED")
    private boolean deleted;
}
