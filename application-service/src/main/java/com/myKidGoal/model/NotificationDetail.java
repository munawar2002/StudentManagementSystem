package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NOTIFICATION_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDetail extends BaseTimeEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "NOTIFICATIONID")
    private Notification notification;

    @Basic
    @Column(name = "SENT_TO")
    private int sentTo;

    @Basic
    @Column(name = "IS_DELIVERED")
    private Boolean delivered;
}
