package com.myKidGoal.model.notification;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NOTIFICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate postingDate;

    @Basic
    @Column(name = "EFFECTIVEDATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate effectiveDate;

    @Basic
    @Column(name = "EXPIRYDATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    @Basic
    @Column(name = "ISDELETED")
    private boolean deleted;
}
