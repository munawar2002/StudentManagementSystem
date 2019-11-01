package com.myKidGoal.model.examination;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.myKidGoal.model.BaseEntity;
import com.myKidGoal.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "DS_SESSIONINFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Session extends BaseEntity {

    @Id
    @Column(name = "Id_Session")
    private Integer id;

    @Basic
    @Column(name = "From")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;

    @Basic
    @Column(name = "To")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;

    @Basic
    @Column(name = "ISEXECUTED")
    @JsonProperty("isExecuted")
    private boolean isExecuted;

    @Basic
    @Column(name = "ISDELETED")
    private boolean deleted;

    @Basic
    @Column(name = "ISACTIVE")
    private boolean active;

    @Basic
    @Column(name = "STATUS")
    private String status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "BRANCH_SESSION", joinColumns = { @JoinColumn(name = "Id_Session") }, inverseJoinColumns = {
            @JoinColumn(name = "Id_Category") })
    private List<Category> category;
}
