package com.myKidGoal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/*
    The Student table entity.
 */
@Entity
@Table(name = "DS_STUDENT")
@NamedNativeQueries(value = {
        @NamedNativeQuery(name = Student.DISCOUNT_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_student WHERE discountpercentage > 0  "),
        @NamedNativeQuery(name = Student.LEFT_STUDENT_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_student WHERE dol IS NOT NULL "),
        @NamedNativeQuery(name = Student.STUDENT_GRADUATED_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_student WHERE TRIM(CauseOfRemoval) ='Pass Out' "),
        @NamedNativeQuery(name = Student.CURRENT_TEACHER_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_employee WHERE dol IS NULL"), })
public class Student implements Serializable {

    public static final String DISCOUNT_COUNT_QUERY = "student.discount.count.query";
    public static final String LEFT_STUDENT_COUNT_QUERY = "left.school.count.query";
    public static final String STUDENT_GRADUATED_COUNT_QUERY = "student.graduated.count.query";
    public static final String CURRENT_TEACHER_COUNT_QUERY = "teacher.current.count.query";

    private Integer id;
    private Section section;
    private Guardian guardian;
    private Guardian parent;
    private PlaceOfBirth placeOfBirth;
    private LastSchool lastSchool;
    private Nationality nationality;
    private Religion religion;
    private House house;
    private Integer regNo;
    private LocalDate regDate;
    private Boolean admissioned;
    private String name;
    private Integer grNo;
    private Boolean male;
    private LocalDate dob;
    private LocalDate doa;
    private LocalDate dol;
    private Boolean leftSchool;
    private String causeOfRemoval;
    private Double discountPercentage;
    private String discountReason;
    private Integer freeze;
    private Integer boarding;
    private Integer userId;
    private LocalDateTime userTime;
    private Integer fakeGrNo;
    private Boolean fixedLateFine;
    private String email;

    @Id
    @Column(name = "ID_Student")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "ID_Sec")
    @JsonProperty("sec")
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Guardian")
    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Parent")
    public Guardian getParent() {
        return parent;
    }

    public void setParent(Guardian parent) {
        this.parent = parent;
    }

    @ManyToOne
    @JoinColumn(name = "Id_PlaceOfBirth")
    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @ManyToOne
    @JoinColumn(name = "Id_LastSchool")
    public LastSchool getLastSchool() {
        return lastSchool;
    }

    public void setLastSchool(LastSchool lastSchool) {
        this.lastSchool = lastSchool;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Nationality")
    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Religion")
    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    @ManyToOne
    @JoinColumn(name = "Id_House")
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Basic
    @Column(name = "RegNo")
    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    @Basic
    @Column(name = "RegDate")
    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "IsAdmissioned")
    @JsonProperty(value = "IsAdmissioned")
    public void setAdmissioned(Boolean admissioned) {
        this.admissioned = admissioned;
    }

    @Basic
    @Column(name = "IsAdmissioned")
    public Boolean getAdmissioned() {
        return admissioned;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "GRNO")
    public Integer getGrNo() {
        return grNo;
    }

    public void setGrNo(Integer grNo) {
        this.grNo = grNo;
    }

    @Basic
    @Column(name = "ISMALE")
    @JsonProperty(value = "IsMale")
    public Boolean getMale() {
        return male;
    }

    @Basic
    @Column(name = "ISMALE")
    public void setMale(Boolean male) {
        this.male = male;
    }

    @Basic
    @Column(name = "DOB")
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "DOA")
    public LocalDate getDoa() {
        return doa;
    }

    public void setDoa(LocalDate doa) {
        this.doa = doa;
    }

    @Basic
    @Column(name = "DOL")
    public LocalDate getDol() {
        return dol;
    }

    public void setDol(LocalDate dol) {
        this.dol = dol;
    }

    @Basic
    @Column(name = "IsLeftSchool")
    @JsonProperty(value = "IsLeftSchool")
    public Boolean getLeftSchool() {
        return leftSchool;
    }

    @Basic
    @Column(name = "IsSchoolLeft")
    public void setLeftSchool(Boolean leftSchool) {
        this.leftSchool = leftSchool;
    }

    @Basic
    @Column(name = "CauseOfRemoval")
    public String getCauseOfRemoval() {
        return causeOfRemoval;
    }

    public void setCauseOfRemoval(String causeOfRemoval) {
        this.causeOfRemoval = causeOfRemoval;
    }

    @Basic
    @Column(name = "DiscountPercentage")
    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Basic
    @Column(name = "DiscountReason")
    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    @Basic
    @Column(name = "Freeze")
    public Integer getFreeze() {
        return freeze;
    }

    public void setFreeze(Integer freeze) {
        this.freeze = freeze;
    }

    @Basic
    @Column(name = "Boarding")
    public Integer getBoarding() {
        return boarding;
    }

    public void setBoarding(Integer boarding) {
        this.boarding = boarding;
    }

    @Basic
    @Column(name = "Id_User")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserTime")
    public LocalDateTime getUserTime() {
        return userTime;
    }

    public void setUserTime(LocalDateTime userTime) {
        this.userTime = userTime;
    }

    @Basic
    @Column(name = "FakeGrNo")
    public Integer getFakeGrNo() {
        return fakeGrNo;
    }

    public void setFakeGrNo(Integer fakeGrNo) {
        this.fakeGrNo = fakeGrNo;
    }

    @Basic
    @Column(name = "IsFixedLateFine")
    @JsonProperty(value = "IsFixedLateFine")
    public Boolean getFixedLateFine() {
        return fixedLateFine;
    }

    @Basic
    @Column(name = "IsFixedLateFine")
    public void setFixedLateFine(Boolean fixedLateFine) {
        this.fixedLateFine = fixedLateFine;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
