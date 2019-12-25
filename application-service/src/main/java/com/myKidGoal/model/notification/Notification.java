package com.myKidGoal.model.notification;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Date postingDate;

    @Basic
    @Column(name = "EFFECTIVEDATE")
    private Date effectiveDate;

    @Basic
    @Column(name = "EXPIRYDATE")
    private Date expiryDate;

    @Basic
    @Column(name = "ISDELETED")
    private boolean deleted;
}
