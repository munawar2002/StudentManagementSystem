package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DS_SEC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section extends BaseEntity {

    @Id
    @Column(name = "Id_Sec")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_Class")
    private Class studentClass;

    @Basic
    @Column(name = "IsDeleted")
    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentClass.getId());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
