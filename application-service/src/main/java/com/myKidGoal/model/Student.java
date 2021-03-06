package com.myKidGoal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
        @NamedNativeQuery(name = Student.CURRENT_TEACHER_COUNT_QUERY, query = "SELECT COUNT(*) FROM ds_employee WHERE dol IS NULL"),
        @NamedNativeQuery(name = Student.TOTAL_DEBIT_QUERY, query = "SELECT SUM(debit) FROM ds_v_slipfeeledger "),
        @NamedNativeQuery(name = Student.TOTAL_CREDIT_QUERY, query = "SELECT SUM(credit) FROM ds_v_slipfeeledger "), })
public class Student implements Serializable {

    public static final String DISCOUNT_COUNT_QUERY = "student.discount.count.query";
    public static final String LEFT_STUDENT_COUNT_QUERY = "left.school.count.query";
    public static final String STUDENT_GRADUATED_COUNT_QUERY = "student.graduated.count.query";
    public static final String CURRENT_TEACHER_COUNT_QUERY = "teacher.current.count.query";
    public static final String TOTAL_DEBIT_QUERY = "total.debit.query";
    public static final String TOTAL_CREDIT_QUERY = "total.credit.query";

    private int id;
    private Section section;
    private Guardian guardian;
    private Guardian parent;
    private PlaceOfBirth placeOfBirth;
    private LastSchool lastSchool;
    private Nationality nationality;
    private Religion religion;
    private House house;
    private Integer regNo;
    private Date regDate;
    private Boolean admissioned;
    private String name;
    private Integer grNo;
    private Boolean male;
    private Date dob;
    private Date doa;
    private Date dol;
    private Boolean leftSchool;
    private String causeOfRemoval;
    private Double discountPercentage;
    private String discountReason;
    private Boolean freeze;
    private Boolean boarding;
    private Integer userId;
    private Date userTime;
    private Integer fakeGrNo;
    private Boolean fixedLateFine;
    private String email;
    private boolean deleted;

    @Id
    @Column(name = "ID_Student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
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
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
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
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "DOA")
    public Date getDoa() {
        return doa;
    }

    public void setDoa(Date doa) {
        this.doa = doa;
    }

    @Basic
    @Column(name = "DOL")
    public Date getDol() {
        return dol;
    }

    public void setDol(Date dol) {
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
    public Boolean getFreeze() {
        return freeze;
    }

    public void setFreeze(Boolean freeze) {
        this.freeze = freeze;
    }

    @Basic
    @Column(name = "Boarding")
    public Boolean getBoarding() {
        return boarding;
    }

    public void setBoarding(Boolean boarding) {
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
    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
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

    @Basic
    @Column(name = "ISDELETED")
    public boolean isDeleted() {
        return deleted;
    }

    @Basic
    @Column(name = "ISDELETED")
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
