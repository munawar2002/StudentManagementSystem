package com.myKidGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "DS_GUARDIAN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQueries(value = {
        @NamedNativeQuery(name = Guardian.SELECT_BY_NICNO, query = "SELECT * FROM ds_guardian WHERE REPLACE(NICNO,'-','') = REPLACE(:cnic,'-','')", resultClass = Guardian.class) })
public class Guardian {

    public static final String SELECT_BY_NICNO = "Guardian.Select.By.NICNO";

    @Id
    @Column(name = "Id_Guardian")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_Profession")
    private Profession profession;

    @Basic
    @Column(name = "Name")
    private String name;

    @Basic
    @Column(name = "NICNo")
    private String cnic;

    @Basic
    @Column(name = "Contact1")
    private String contact1;

    @Basic
    @Column(name = "Contact2")
    private String contact2;

    @Basic
    @Column(name = "Contact3")
    private String contact3;

    @Basic
    @Column(name = "Address")
    private String address;

    @Basic
    @Column(name = "ToDate")
    private LocalDate toDate;

    @Basic
    @Column(name = "ID_User")
    private Integer userId;

    @Basic
    @Column(name = "UserTime")
    private LocalDateTime userTime;

    @ManyToOne
    @JoinColumn(name = "Id_Area")
    private Area area;

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
