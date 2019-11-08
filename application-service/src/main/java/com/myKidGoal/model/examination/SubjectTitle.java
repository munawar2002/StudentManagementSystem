package com.myKidGoal.model.examination;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myKidGoal.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DS_SUBJECTTITLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubjectTitle extends BaseTimeEntity {

    @Id
    @Column(name = "ID_SUBJECTTITLE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "Title")
    private String title;

    @Basic
    @Column(name = "Short")
    @JsonProperty(value = "short")
    private String shortTitle;

    @Basic
    @Column(name = "Color")
    private String color;

    @Basic
    @Column(name = "ISEXTRAACTIVITY")
    @JsonProperty(value = "isExtraActivity")
    private boolean extraActivity;

}
