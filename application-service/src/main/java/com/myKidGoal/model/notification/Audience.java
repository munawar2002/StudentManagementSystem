package com.myKidGoal.model.notification;

import com.myKidGoal.model.BaseEntity;
import com.myKidGoal.model.Category;
import com.myKidGoal.model.Class;
import com.myKidGoal.model.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "AUDIENCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audience extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "ROLEID")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "BRANCHID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "CLASSID")
    private Class studentClass;

    @ManyToOne
    @JoinColumn(name = "SECTIONID")
    private Section section;

}
