package com.myKidGoal.model.notification;

import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NOTIFICATION_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotificationDetail extends BaseTimeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "NOTIFICATIONID")
    private Notification notification;

    @Basic
    @Column(name = "SENT_TO")
    private String sentTo;

    @Basic
    @Column(name = "IS_DELIVERED")
    private Boolean delivered;
}
